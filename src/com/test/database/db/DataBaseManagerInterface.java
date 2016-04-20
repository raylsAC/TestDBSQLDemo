package com.test.database.db;

import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * 数据库业务管理类要实现的接口
 * 基本方法为增、删、改、查
 * @author Rayls
 *
 */

public interface DataBaseManagerInterface {

	/**
	 * 新增记录
	 * 
	 * @param 新增内容
	 *            key-value
	 */
	abstract void Add(List<ContentValues> values);

	/**
	 * 更新记录
	 * 
	 * @param values
	 *            更新内容 key-value
	 * @param whereClause
	 *            更新条件 例如：id=?，?为通配符
	 * @param whereArgs
	 *            条件集合 例如：new String[]{"1"}
	 *            
	 *  cv = new ContentValues();
	 *  cv.put("age", 35);  
	 *  db.update("person", cv, "name = ?", new String[]{"john"}); 
	 * 
	 */
	abstract void Update(ContentValues values, String whereClause,
			String[] whereArgs);

	/**
	 * 删除记录
	 * 
	 * @param whereClause
	 *            删除条件 例如：id=?，?为通配符
	 * @param whereArgs
	 *            删除集合 例如：new String[]{"1"}
	 * 
	 */
	abstract boolean Delete(String whereClause, String[] whereArgs);

	/**
	 * 查询
	 * 
	 * 必须在Cursor使用之后，才可以关闭数据库连接。 例如：Cursor.moveToNext()执行的时候，才会去查询数据库中是否有数据。
	 * 
	 * @param columns
	 *            返回列
	 * @param selection
	 *            查询条件 例如：id=?，?为通配符
	 * @param selectionArgs
	 *            条件集合 例如： new String[]{"1"}
	 * @param groupBy
	 *            分组
	 * @param having
	 * @param orderBy
	 *            排序
	 * 
	 */
	abstract Cursor Query(String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy);

}
