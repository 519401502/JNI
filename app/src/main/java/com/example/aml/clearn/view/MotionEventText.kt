package com.example.aml.clearn.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.Button

/**
 * Created by 18624915319 on 2017/12/5.
 */
class MotionEventText: Button{

    init {

    }

    constructor(context: Context) : super(context){

    }

    constructor(context: Context, a : AttributeSet) : super(context, a){

    }

    constructor(context: Context, a:AttributeSet, defStyleAttr : Int) : super (context, a, defStyleAttr){

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        event ?: return false
        Log.d("~", "用户触发了onTouchEvent")
        if (event.action == MotionEvent.ACTION_OUTSIDE){
            Log.d("~", "用户触发了action_outside")
        }
        return false

    }
}