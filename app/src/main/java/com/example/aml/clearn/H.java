package com.example.aml.clearn;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;
/**
 * Created by 18624915319 on 2017/12/10.
 */

public class H extends Handler {

    private WeakReference<Context> mWeakReference;

    public H(Context aContext){
        mWeakReference = new WeakReference<>(aContext);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

    }
}
