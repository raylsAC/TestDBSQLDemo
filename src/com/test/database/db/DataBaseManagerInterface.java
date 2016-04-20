package com.test.database.db;

import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * ���ݿ�ҵ�������Ҫʵ�ֵĽӿ�
 * ��������Ϊ����ɾ���ġ���
 * @author Rayls
 *
 */

public interface DataBaseManagerInterface {

	/**
	 * ������¼
	 * 
	 * @param ��������
	 *            key-value
	 */
	abstract void Add(List<ContentValues> values);

	/**
	 * ���¼�¼
	 * 
	 * @param values
	 *            �������� key-value
	 * @param whereClause
	 *            �������� ���磺id=?��?Ϊͨ���
	 * @param whereArgs
	 *            �������� ���磺new String[]{"1"}
	 *            
	 *  cv = new ContentValues();
	 *  cv.put("age", 35);  
	 *  db.update("person", cv, "name = ?", new String[]{"john"}); 
	 * 
	 */
	abstract void Update(ContentValues values, String whereClause,
			String[] whereArgs);

	/**
	 * ɾ����¼
	 * 
	 * @param whereClause
	 *            ɾ������ ���磺id=?��?Ϊͨ���
	 * @param whereArgs
	 *            ɾ������ ���磺new String[]{"1"}
	 * 
	 */
	abstract boolean Delete(String whereClause, String[] whereArgs);

	/**
	 * ��ѯ
	 * 
	 * ������Cursorʹ��֮�󣬲ſ��Թر����ݿ����ӡ� ���磺Cursor.moveToNext()ִ�е�ʱ�򣬲Ż�ȥ��ѯ���ݿ����Ƿ������ݡ�
	 * 
	 * @param columns
	 *            ������
	 * @param selection
	 *            ��ѯ���� ���磺id=?��?Ϊͨ���
	 * @param selectionArgs
	 *            �������� ���磺 new String[]{"1"}
	 * @param groupBy
	 *            ����
	 * @param having
	 * @param orderBy
	 *            ����
	 * 
	 */
	abstract Cursor Query(String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy);

}
