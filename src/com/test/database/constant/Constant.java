package com.test.database.constant;


/**
 * ����
 * @author Rayls
 *
 */
public class Constant {

	//������ַ�����
	public final static String SQL_CREATE_TABLE = "create table if not exists address(id INTEGER PRIMARY KEY AUTOINCREMENT, addrdetail varchar(50), pinyin varchar(50))";
	//��ַ����
	public final static String TABLE_NAME = "address";
	
	//����
	public final static String TABLE_COLUMN_ADDRDETAIL = "addrdetail";
	public final static String TABLE_COLUMN_PINYIN = "pinyin";
	
	//���ݿ���
	public final static String DATABASE_NAME = "Test.db";
	//���ݿ�汾
	public final static int DATABASE_VERSION = 1;


}

