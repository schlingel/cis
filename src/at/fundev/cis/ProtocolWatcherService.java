package at.fundev.cis;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.FileObserver;
import android.os.IBinder;
import at.fundev.cis.communication.IMessage;

public class ProtocolWatcherService extends Service {
	private static final String[] OBSERVABLE_FILES = { "/proc/net/tcp", "/proc/net/udp", "/proc/net/udp6", "/proc/net/tcp6" };
	
	private FileObserver[] observers;
	
	public class ProtocolWatcherBinder extends Binder {
		ProtocolWatcherService getService() {
			return ProtocolWatcherService.this;
		}
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		observers = new FileObserver[OBSERVABLE_FILES.length];
		
		for(int i = 0; i < observers.length; i++) {
			observers[i] = new FileObserver(OBSERVABLE_FILES[i], FileObserver.MODIFY) {
				@Override
				public void onEvent(int event, String path) {
					extractDataFromLog(path);
				}
			};
		}
	}
	
	private void extractDataFromLog(String path) {
		
	};
	
	private final Binder binder = new ProtocolWatcherBinder();
	
	
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
	public void processMessage(IMessage message) {
		
	}
}
