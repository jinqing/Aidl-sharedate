package com.example.aidlserver;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.aidlserver.contentprovider.DbHelper;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setShareprefer();
		setContentprovider();
	}

	public void setShareprefer(){
		SharedPreferences sp=getSharedPreferences("start", Context.MODE_WORLD_READABLE);
		sp.edit().putString("name", "÷‹–«≥€").commit();
	}
	
	public void setContentprovider(){
		DbHelper db=new DbHelper(this);
		ContentValues values=new ContentValues();
		values.put("name", "÷‹–«≥€");
		values.put("age", 50);
		db.getReadableDatabase().insert("user", null, values);
		db.close();
	}

}
