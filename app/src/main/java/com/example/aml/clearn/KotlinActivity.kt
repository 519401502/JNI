package com.example.aml.clearn

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

/**
* Created by 18624915319 on 2017/11/20.
*/
class KotlinActivity : AppCompatActivity() {
    init {
        System.loadLibrary("native-lib")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var input = resources.assets.open("aaa.jpg")
//        var length = input.available()
//        var buffer: ByteArray = kotlin.ByteArray(length)
//        input.read(buffer)
        var huanhuan = Zhao()
        huanhuan.age = 21
        huanhuan.name = "赵焕焕"
        objectToJNI(huanhuan)
//        var bitmap: Bitmap? = null
//        var ints: IntArray? = kotlin.IntArray(bitmap?.width!! * bitmap.height)
//        bitmap.getPixels(ints, 0, 0, 0 , 0, bitmap.width, bitmap.height)



        val tv = findViewById<View>(R.id.sample_text) as TextView
//        tv.text = bitmaplib()
    }

    external fun objectToJNI(zhao: Zhao): Void
//
//    external fun stringFromJNI(): String
//
//    external fun bitmaplib(): String
//
//    external fun text(): String
}