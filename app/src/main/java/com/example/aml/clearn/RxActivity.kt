package com.example.aml.clearn

import android.annotation.SuppressLint
import android.app.Application
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import rx.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

import android.support.design.widget.CoordinatorLayout
import android.util.Pair
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.widget.ViewFlipper


class RxActivity : AppCompatActivity() {

//    lateinit var button1: Button
    lateinit var button2: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)

        rxText()

//        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        val fillt = findViewById<ViewFlipper>(R.id.flipper)
        fillt.setFlipInterval(1000)
        fillt.setInAnimation(this, R.anim.abc_fade_in)
        fillt.setOutAnimation(this, R.anim.abc_fade_out)
        fillt.isAutoStart = true
        fillt.startFlipping()
//        var pair = Pair.create()
//        Application.ActivityLifecycleCallbacks

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
//        event ?: return
        Log.d("~", "收到拦截")
        button2.x = event?.x!!
        button2.y = event.y

        return true
    }

    private fun rxText(): Unit {
//        被观察者
        var observable: Observable<String> = Observable.create({
            it.onNext("hello")
        })


//        观察者
        var observe = object : Observer<String>{
            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {

            }

            override fun onNext(t: String?) {

            }

        }


//        事件发生在io线程
        observable.subscribeOn(Schedulers.io())
//        回调在主线程
        observable.observeOn(AndroidSchedulers.mainThread())
//        观察者订阅
        observable.subscribe(observe)

    }

    fun rxText2(): Unit {
        val students = ArrayList<String>()
        Observable.create<Bitmap> {

        }
//        得到默认的SharedPrerferences
        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        Observable.from(students).map {

        }

    }

    class MyBe : CoordinatorLayout.Behavior<TextView>() {

    }
}
