package com.example.aidlclient.shareprefer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;

/*
 * sharepreferences方式共享数据
 */
public class SharePrefer {
	public static String getShareprefer(Context context,String packageName,String tableName,String name){
		try {
			Context mComtext=context.createPackageContext(packageName, Context.CONTEXT_IGNORE_SECURITY);
			SharedPreferences sp=mComtext.getSharedPreferences(tableName, Context.MODE_WORLD_READABLE);
			return sp.getString(name, "获取不到");
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
