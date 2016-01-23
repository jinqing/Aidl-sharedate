package com.example.aidlserver;


import aidl.hello;
import aidl.hello.Stub;
import aidl.word;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class Aidlserver extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i("service on bind", "*******");
		return mBinder;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.i("service on create", "*******");
	}
	
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}
	
	private final hello.Stub mBinder=new Stub() {

		@Override
		public void callback(word wd) throws RemoteException {
			// TODO Auto-generated method stub
			Log.i("服务器端打印：", "com.example.helloword");
			wd.call("周星驰");
			
		}
	};
}
