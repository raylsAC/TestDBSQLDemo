package com.test.database.db;



import com.test.database.constant.Constant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 建一个基类来作为维护和升级数据库
 * @author Rayls
 * 
 */
public class DataBaseHelper extends SQLiteOpenHelper {

	
	public DataBaseHelper(Context context) {
		super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION);

	}

	
    //数据库第一次被创建时onCreate会被调用
	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建地址表
		db.execSQL(Constant.SQL_CREATE_TABLE);
	}
	
    //如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		try {
			for (int i = oldVersion; i < newVersion; i++) {
				switch (i) {
				case 1:
					DatabaseVersionManagement.UpgradedVersion1To2(db);
					break;

				default:
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
