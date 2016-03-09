package com.qiyu.ui;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.bindera.R;
import com.qiyu.ui.aidl.IConectionService;
import com.qiyu.ui.aidl.IListenner;
import com.qiyu.util.ConnectionService;

public class MainActivity extends Activity{

	Button btn1;
	TextView tx1;
	
	IConectionService myService;
	
	Context sInstance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.main_layout);
	
		sInstance = this;
		
		btn1 = (Button) findViewById(R.id.btn1);
		tx1 = (TextView) findViewById(R.id.tx1);
		
	
		
		
	
		
		Intent intent = new Intent(sInstance,ConnectionService.class);
		sInstance.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
				
				
			}
		});
	
	}
	
	private ServiceConnection serviceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.e("innog", "未连接=======================================>");
			
			
			
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			
			myService = IConectionService.Stub.asInterface(service);
			
			try {
				myService.setOnChangeListenner(new IListenner.Stub() {
					
					@Override
					public void recieve(String str) throws RemoteException {
						// TODO Auto-generated method stub
						tx1.setText(str);
					}
				});
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Log.e("innog", "已连接=======================================>");
			
			
			
			
		}
	};
	
	
}
