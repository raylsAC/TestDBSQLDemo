package com.test.database.db;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * ����һ�����ݿ�������
 * ���ڹ�������ʵ�ʵ�ҵ���߼�
 * 
 * @author Rayls
 *
 */
public class BaseDataBaseManager implements DataBaseManagerInterface{
	
	private DataBaseHelper dbHelper = null;
	private SQLiteDatabase db = null;
	private Context mContext = null;
	
	public BaseDataBaseManager(Context context) {
		this.mContext = context;
	}

	public void openDBConnect() {
		if (dbHelper == null) {
			dbHelper = new DataBaseHelper(mContext);
		}
		//�����ݿ�
		//��ΪgetWritableDatabase�ڲ�������mContext.openOrCreateDatabase(mName, 0, mFactory); 
		db = dbHelper.getWritableDatabase();//�ڲ����п�
		//��ʼ����
		db.beginTransaction();
	}
	
	public void setTransactionSuccessfull() {
		//��������ɹ�
		db.setTransactionSuccessful();
	}
	
	public void closeDBConnect() {
		if (db != null) {
			//��������
			db.endTransaction();
			db.close();
		}
		if (dbHelper != null) {
			dbHelper.close();
		}
	}
	
	@Override
	public void Add(List<ContentValues> values) {
		
	}

	@Override
	public void Update(ContentValues values, String whereClause, String[] whereArgs) {
		
	}

	@Override
	public boolean Delete(String whereClause, String[] whereArgs) {
		return false;
	}

	@Override
	public Cursor Query(String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {
		return null;
	}
	
	public DataBaseHelper getDbHelper() {
		return dbHelper;
	}

	public SQLiteDatabase getDb() {
		return db;
	}

}
