package com.example.aml.clearn

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.example.aml.clearn.note.DialogFragmentText

class Main4Activity : AppCompatActivity() {

    lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)



//        image = findViewById(R.id.imageView5)
//        initArray()

//        val builder = AlertDialog.Builder(this)
//        builder.setView(R.layout.qq_activity_main4)
//        var alertDialog = builder.create()
//        alertDialog.setCancelable(true)
//        alertDialog.setCanceledOnTouchOutside(false)
//        val window = alertDialog.getWindow()
//        window!!.setBackgroundDrawableResource(android.R.color.transparent)
//        alertDialog.show()

//        mDropDownMenu.setDropDownMenu(tabs, popupViews, contentView);

    }


    private fun initArray() {

        var bitma3 = BitmapFactory.decodeResource(resources, R.drawable.image3)

        var bitmap = Bitmap.createBitmap(bitma3.width, bitma3.height, Bitmap.Config.ARGB_8888)

        var array = FloatArray(20)
        for (i in 0 until array.size){
            if (i % 6 == 0)
                array[i] = 2f
            else {
                array[i] = 0f
            }
        }
        var colors = ColorMatrix()
        colors.set(array)

        var canvas = Canvas(bitmap)
        var paint = Paint()
        paint.colorFilter = ColorMatrixColorFilter(colors)


        canvas.drawBitmap(bitma3, 0f, 0f, paint)
        image.setImageBitmap(bitmap)
    }


    override fun onDestroy() {
        super.onDestroy()
//        防止内存泄漏
    }


}
