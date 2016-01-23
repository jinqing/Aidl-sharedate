package com.example.aidlclient.contentprovider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/*
 * contentprovider方式共享数据
 */
public class ContentProvid {
	public static Cursor getContentprovid(Context context,String url){
		Uri uri=Uri.parse(url);
		ContentResolver resolver = context.getContentResolver();
		Cursor cursor = resolver.query(uri,null, null, null, null);
		return cursor;
	}
}
