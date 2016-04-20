package com.test.database.db;



import com.test.database.constant.Constant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * ��һ����������Ϊά�����������ݿ�
 * @author Rayls
 * 
 */
public class DataBaseHelper extends SQLiteOpenHelper {

	
	public DataBaseHelper(Context context) {
		super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION);

	}

	
    //���ݿ��һ�α�����ʱonCreate�ᱻ����
	@Override
	public void onCreate(SQLiteDatabase db) {
		//������ַ��
		db.execSQL(Constant.SQL_CREATE_TABLE);
	}
	
    //���DATABASE_VERSIONֵ����Ϊ2,ϵͳ�����������ݿ�汾��ͬ,�������onUpgrade 
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
