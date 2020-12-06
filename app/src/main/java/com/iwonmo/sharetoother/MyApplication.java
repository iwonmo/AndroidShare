package com.iwonmo.sharetoother;

import android.app.Application;
import android.os.StrictMode;
import android.os.StrictMode.VmPolicy.Builder;

public class MyApplication extends Application
{
    public void onCreate()
    {
        super.onCreate();
        StrictMode.VmPolicy.Builder localBuilder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(localBuilder.build());
        localBuilder.detectFileUriExposure();
    }
}