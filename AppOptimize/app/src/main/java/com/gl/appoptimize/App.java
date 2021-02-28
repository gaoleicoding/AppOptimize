package com.gl.appoptimize;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.tencent.bugly.crashreport.CrashReport;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        CrashReport.initCrashReport(getApplicationContext(), "5e41caa713", false);
        DoraemonKit.install(App.this, "pId");
    }
}