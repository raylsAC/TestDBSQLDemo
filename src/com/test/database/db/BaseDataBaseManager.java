package com.test.database.db;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 建立一个数据库管理基类
 * 用于管理我们实际的业务逻辑
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
		//打开数据库
		//因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory); 
		db = dbHelper.getWritableDatabase();//内部会判空
		//开始事务
		db.beginTransaction();
	}
	
	public void setTransactionSuccessfull() {
		//设置事务成功
		db.setTransactionSuccessful();
	}
	
	public void closeDBConnect() {
		if (db != null) {
			//结束事务
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
