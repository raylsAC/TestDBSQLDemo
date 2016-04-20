package com.test.database.db;


import com.test.database.constant.Constant;

import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库版本管理
 * 
 * @author Rayls
 * 
 */
public class DatabaseVersionManagement {

	/**
	 * 假设数据库版本升级：1 to 2
	 * 
	 **/
	public static void UpgradedVersion1To2(SQLiteDatabase db) {

		try {
			//把现在的address表重命名并生成另一张表
			db.execSQL("alter table address rename to temp_address");
			
			//删除现在的address
			db.execSQL("drop table if exists address");
			
			//重新建一张address表
			db.execSQL(Constant.SQL_CREATE_TABLE);

			//从旧表中导入数据到新表
			db.execSQL("insert into address select id, addrdetail, pinyin from temp_address");

			//删除旧表
			db.execSQL("drop table if exists temp_address");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
