package com.qiyu.util;

import com.qiyu.ui.aidl.IConectionService;
import com.qiyu.ui.aidl.IConectionService.Stub;
import com.qiyu.ui.aidl.IListenner;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

public class ConnectionService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return myBinder;
	}

	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		Log.e("innog", "service oncreate");
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}
	
	RemoteCallbackList<IListenner> remoteCallbackList = new RemoteCallbackList<IListenner>();
	
	IListenner mylistenner;
	
	private IConectionService.Stub myBinder = new Stub() {

		
		
		@Override
		public void send(String msg) throws RemoteException {
			// TODO Auto-generated method stub
			
			Log.e("innog", "收到信息===>"+msg+mylistenner);
			
			remoteCallbackList.beginBroadcast();
			
			int n = remoteCallbackList.getRegisteredCallbackCount();
			
			for (int i = 0; i < n; i++) {
				
				remoteCallbackList.getBroadcastItem(i).recieve(msg);
				
			}
			
			
			remoteCallbackList.finishBroadcast();
			
			
			//mylistenner.recieve(msg);
			
			
		}

		@Override
		public void recieve(String msg) throws RemoteException {
			// TODO Auto-generated method stub
			
			
			
			
		}

		@Override
		public void setOnChangeListenner(IListenner listenner)
				throws RemoteException {
			// TODO Auto-generated method stub
			
			Log.e("innog", "注册Listenner"+listenner);
			
			if (null != listenner) {
				
				remoteCallbackList.register(listenner);
				
			}
			
			
		}


			
		
	};
	
	
}
