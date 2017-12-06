package com.example.aml.clearn

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Picture
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.transition.ChangeBounds
import android.support.transition.Scene
import android.support.transition.TransitionManager
import android.support.v4.app.JobIntentService
import android.util.Log
import android.view.*
import android.widget.ImageView
import com.example.aml.clearn.view.BitmapView


class TransitionActivity : AppCompatActivity() {

    private lateinit var mViewGroup: ViewGroup

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)
//        startService(Intent(this, SS::class.java))
        mViewGroup = findViewById(R.id.constraint)
        val bitmapView = BitmapView(this)
        var newParams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(200, 400)
        bitmapView.layoutParams = newParams
        mViewGroup.addView(bitmapView)

        var listener = GestureDetector(this, object : GestureDetector.OnGestureListener {
            override fun onShowPress(p0: MotionEvent?) {

            }

            override fun onSingleTapUp(p0: MotionEvent?): Boolean {
                return false
            }

            override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
                return false
            }

            override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
                return false
            }

            override fun onLongPress(p0: MotionEvent?) {
                Log.d("~", "长按")
            }

            override fun onDown(p0: MotionEvent?): Boolean {
                Log.d("~", "按下")
                return false
            }

        })
//        GestureDetector 接管触摸监听
        mViewGroup.setOnTouchListener { _, p1 -> listener.onTouchEvent(p1) }

        var picture = Picture()
        var canvas = picture.beginRecording(100, 100)
        var paint = Paint()
        paint.style = Paint.Style.STROKE
        paint.color = Color.RED
        paint.isAntiAlias = true
        canvas.drawCircle(100f, 100f, 50f, paint)
        picture.endRecording()
        bitmapView.requestDraw(picture)
    }

    fun start(aView: View, vararg views: View) {
//        TransitionManager.beginDelayedTransition(mViewGroup)
        var scen: Scene = Scene(mViewGroup, LayoutInflater.from(this).inflate(R.layout.activity_transition2, null, false))
        TransitionManager.go(scen, ChangeBounds())
//        var params :ViewGroup.LayoutParams = aView.layoutParams
//        params.height = aView.layoutParams.height * 2
//        params.width = aView.layoutParams.width * 2
//        aView.layoutParams = params
//        for (view in views){
//            if (view.visibility == View.VISIBLE){
//                view.visibility = View.INVISIBLE
//            } else {
//                view.visibility = View.VISIBLE
//            }
//        }
    }

    class SS : JobIntentService() {

        override fun onHandleWork(intent: Intent) {
            for (i in 0..1000) {
                Thread.sleep(800)
                Log.d("~", "正在执行JobIntentService")
            }
        }

    }
}
