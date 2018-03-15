package com.bbva.intranet.behappy.app;

import android.content.res.Configuration;

public class Application extends android.app.Application{

	private static Application singleton;

	public static Application getInstance(){
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
	
}
