package com.example.aml.clearn;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by 18624915319 on 2018/1/1.
 */

public class App extends Application implements Application.ActivityLifecycleCallbacks{

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity aActivity, Bundle aBundle) {

    }

    @Override
    public void onActivityStarted(Activity aActivity) {

    }

    @Override
    public void onActivityResumed(Activity aActivity) {

    }

    @Override
    public void onActivityPaused(Activity aActivity) {

    }

    @Override
    public void onActivityStopped(Activity aActivity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity aActivity, Bundle aBundle) {

    }

    @Override
    public void onActivityDestroyed(Activity aActivity) {

    }
}
