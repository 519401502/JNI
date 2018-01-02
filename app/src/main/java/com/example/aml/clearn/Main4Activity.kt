package com.example.aml.clearn

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log

class Main4Activity : AppCompatActivity() {

    lateinit var handlerMessage: HandlerThread

    val handler = object : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            Log.d("~", "收到handlerMessage发送的消息")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        training()


    }

    fun training(): Unit {
        handlerMessage = HandlerThread("main4_activity")
//        特殊线程开始启动
        handlerMessage.start()
        val h = Handler(handlerMessage.looper, object : Handler.Callback{
            override fun handleMessage(p0: Message?): Boolean {
//                执行耗时操作
                Thread.sleep(3000)
                handler.sendEmptyMessage(1)
                return true
            }
        })
        for (i in 0..10){
            h.sendEmptyMessage(1)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
//        防止内存泄漏
        handler.removeCallbacksAndMessages(null)
    }


}
