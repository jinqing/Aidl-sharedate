package com.example.aidlserver.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper{
	private  static final String DBNAME="user.db";

	public DbHelper(Context context) {
		super(context, DBNAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE user (id integer primary key autoincrement, name varchar(20), age integer)";   
        db.execSQL(sql);//执行有更改的sql语句
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS user");   
        onCreate(db);
	}

}
