package com.test.database.db;


import com.test.database.constant.Constant;

import android.database.sqlite.SQLiteDatabase;

/**
 * ���ݿ�汾����
 * 
 * @author Rayls
 * 
 */
public class DatabaseVersionManagement {

	/**
	 * �������ݿ�汾������1 to 2
	 * 
	 **/
	public static void UpgradedVersion1To2(SQLiteDatabase db) {

		try {
			//�����ڵ�address����������������һ�ű�
			db.execSQL("alter table address rename to temp_address");
			
			//ɾ�����ڵ�address
			db.execSQL("drop table if exists address");
			
			//���½�һ��address��
			db.execSQL(Constant.SQL_CREATE_TABLE);

			//�Ӿɱ��е������ݵ��±�
			db.execSQL("insert into address select id, addrdetail, pinyin from temp_address");

			//ɾ���ɱ�
			db.execSQL("drop table if exists temp_address");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
