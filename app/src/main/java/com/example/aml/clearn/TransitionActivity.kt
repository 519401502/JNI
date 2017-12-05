package com.example.aml.clearn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.transition.ChangeBounds
import android.support.transition.Scene
import android.support.transition.TransitionManager
import android.support.v4.app.JobIntentService
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aml.clearn.view.BitmapView

class TransitionActivity : AppCompatActivity() {

    lateinit var mViewGroup: ViewGroup

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)
        startService(Intent(this, SS::class.java))
        mViewGroup = findViewById(R.id.constraint)
        val bitmapView = BitmapView(this)
        var newParams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(200, 400)
        bitmapView.layoutParams = newParams
        mViewGroup.addView(bitmapView)

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
            for (i in 0..1000){
                Thread.sleep(800)
                Log.d("~", "正在执行JobIntentService")
            }
        }

    }
}
