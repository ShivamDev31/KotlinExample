package com.shivamdev.kotlinexample.common;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by shivam on 19/1/17.
 */

public class KotlinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}