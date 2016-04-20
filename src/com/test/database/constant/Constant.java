package com.test.database.constant;


/**
 * 常量
 * @author Rayls
 *
 */
public class Constant {

	//创建地址表语句
	public final static String SQL_CREATE_TABLE = "create table if not exists address(id INTEGER PRIMARY KEY AUTOINCREMENT, addrdetail varchar(50), pinyin varchar(50))";
	//地址表名
	public final static String TABLE_NAME = "address";
	
	//列项
	public final static String TABLE_COLUMN_ADDRDETAIL = "addrdetail";
	public final static String TABLE_COLUMN_PINYIN = "pinyin";
	
	//数据库名
	public final static String DATABASE_NAME = "Test.db";
	//数据库版本
	public final static int DATABASE_VERSION = 1;


}

