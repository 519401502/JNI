package com.example.aml.clearn

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.util.DisplayMetrics



class SevenActivity : AppCompatActivity() {

    private var slop: Int = 0
    private var x: Float = 0.toFloat()
    private var y: Float = 0.toFloat()

    //拦截的范围
    private var scope: Int = 0
    private var halfScope: Int = 0

    private lateinit var mConstraintLayout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven)

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels

        scope = width / 6
        halfScope = width / 2
        mConstraintLayout = findViewById(R.id.constraint_layout)
//        触发移动事件的最小距离
        slop = ViewConfiguration.get(this).scaledTouchSlop
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                x = event.x
                y = event.y
            }
            MotionEvent.ACTION_MOVE ->
                if (event.x - x > 0
                        && x.toInt() <= scope
                        && Math.abs(event.x - x) > Math.abs(event.y - y)
                        && Math.abs(event.x - x) > slop) {
                    (mConstraintLayout.parent as ViewGroup).scrollTo(-(event.x.toInt() - x.toInt()), 0)
                    return true
                }
            MotionEvent.ACTION_UP -> {
                if (event.x < halfScope) {
                    // 如果没有拉取过半，则回退
                    (mConstraintLayout.parent as ViewGroup).scrollTo(0, 0)
                } else {
                    if (event.x - x > 0
                            && x.toInt() <= scope
                            && Math.abs(event.x - x) > Math.abs(event.y - y)
                            && Math.abs(event.x - x) > slop) {
                        finish()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

}

