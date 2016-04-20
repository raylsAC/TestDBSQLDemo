package com.test.database.db.address;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.test.database.constant.Constant;
import com.test.database.db.BaseDataBaseManager;
import com.test.database.model.AddressInfo;

/**
 * address表操作管理类
 * @author Rayls
 *
 */
public class AddressDBManager extends BaseDataBaseManager {
	
	public AddressDBManager(Context context) {
		super(context);
	}

	@Override
	public void Add(List<ContentValues> values) {
		try {
			openDBConnect();
			for (int i = 0; i < values.size(); i++) {
				getDb().insert(Constant.TABLE_NAME, null, values.get(i));			
			}
			setTransactionSuccessfull();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
	}

	@Override
	public void Update(ContentValues values, String whereClause,
			String[] whereArgs) {
		try {
			openDBConnect();

			getDb().update(Constant.TABLE_NAME, values, whereClause, whereArgs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
	}

	@Override
	public boolean Delete(String whereClause, String[] whereArgs) {
		boolean isDeleteSuccess = true;
		try {
			openDBConnect();
			getDb().delete(Constant.TABLE_NAME, whereClause, whereArgs);

		} catch (Exception e) {
			isDeleteSuccess = false;
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
		return isDeleteSuccess;
	}

	@Override
	public Cursor Query(String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {
		Cursor cursor = null;
		try {
			openDBConnect();

			cursor = getDb().query(Constant.TABLE_NAME, columns, selection,
					selectionArgs, groupBy, having, orderBy);
			while(cursor.moveToNext()){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}

		return cursor;
	}
	
	//从地址表中获取地址列表信息
	public List<AddressInfo> getAddressInfosFromDB() {
		List<AddressInfo>  lists = new ArrayList<AddressInfo>();
		Cursor cursor = null;
		
		try {
			openDBConnect();
			
			cursor = getDb().rawQuery("select * from "+Constant.TABLE_NAME, null);
			
//			cursor = getDb().query(Constant.TABLE_NAME, null, null, null, null, null, null);
			while(cursor.moveToNext()){
				AddressInfo addr = new AddressInfo();
				addr.setAddrDetail(cursor.getString(cursor.getColumnIndex(Constant.TABLE_COLUMN_ADDRDETAIL)));
				addr.setAddrPinyin(cursor.getString(cursor.getColumnIndex(Constant.TABLE_COLUMN_PINYIN)));
				lists.add(addr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
		return lists;
		
	}


	
	public List<AddressInfo> queryAddressInfoFromSearch(String str) {
		List<AddressInfo>  lists = new ArrayList<AddressInfo>();
		Cursor cursor = null;
		
		try {
			openDBConnect();
			cursor = getDb().query(Constant.TABLE_NAME, null, Constant.TABLE_COLUMN_ADDRDETAIL+" like ? or pinyin like ?", new String[]{"%"+str+"%","%"+str+"%"}, null, null, null);
			while(cursor.moveToNext()){	
				AddressInfo addr = new AddressInfo();
				addr.setAddrDetail(cursor.getString(cursor.getColumnIndex(Constant.TABLE_COLUMN_ADDRDETAIL)));
				addr.setAddrPinyin(cursor.getString(cursor.getColumnIndex(Constant.TABLE_COLUMN_PINYIN)));
				lists.add(addr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
		return lists;
		
	}

}

