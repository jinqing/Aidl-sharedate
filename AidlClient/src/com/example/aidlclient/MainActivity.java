package com.example.aidlclient;

import com.example.aidlclient.contentprovider.ContentProvid;
import com.example.aidlclient.shareprefer.SharePrefer;

import aidl.hello;
import aidl.word;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	hello hi;
	TextView tv1,tv2,tv3;
	Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bindService(new Intent("com.example.aidlserver.service"), connection, Context.BIND_AUTO_CREATE);
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		tv3=(TextView)findViewById(R.id.textView3);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	private ServiceConnection connection=new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.i("disconnect service", "*******");
			hi=null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			hi=hello.Stub.asInterface(service);
			Log.i("connect service", "*******");
		}
	};
	
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.button1:
			try {
				hi.callback(new word.Stub() {
					@Override
					public void call(String result) throws RemoteException {
						// TODO Auto-generated method stub
						tv1.setText("aidl·µ»Ø£º"+result);
					}
				});
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.button2:
			tv2.setText(SharePrefer.getShareprefer(MainActivity.this, "com.example.aidlserver", "start", "name"));
			break;
		case R.id.button3:
			cursor=ContentProvid.getContentprovid(this, "content://com.example.aidlserver.contentprovider.UserContentprovider/user");
			while(cursor.moveToNext()){
				tv3.setText(cursor.getString(cursor.getColumnIndex("name"))+":"+cursor.getInt(cursor.getColumnIndex("age")));
			}
			break;

		default:
			break;
		}
	}
	
}
