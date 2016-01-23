package com.example.aidlserver.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class UserContentprovider extends ContentProvider{
	private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
	static{
		MATCHER.addURI("com.example.aidlserver.contentprovider.UserContentprovider", "user", 1); 
		MATCHER.addURI("com.example.aidlserver.contentprovider.UserContentprovider", "user/#", 2);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		DbHelper db=new DbHelper(getContext());
		SQLiteDatabase database=db.getReadableDatabase();
		Log.i("MATCHER.match(uri)", MATCHER.match(uri)+"");
		
		switch (MATCHER.match(uri)) {
		case 1:
			return database.query("user", projection, selection, selectionArgs, null, null, sortOrder);
		case 2:
			long id=ContentUris.parseId(uri);
			String where="id="+id;
			if(selection!=null && !"".equals(selection)){   
                where = selection + " and " + where;   
            }   
            return database.query("user", projection, where, selectionArgs, null, null, sortOrder);
		default:
			throw new IllegalArgumentException("Unkwon Uri:"+ uri.toString());  
		}
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
