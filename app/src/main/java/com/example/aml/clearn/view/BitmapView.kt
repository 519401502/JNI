package com.example.aml.clearn.view

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * Created by 18624915319 on 2017/12/1.
 */
class BitmapView(context: Context?) : View(context) {

    lateinit var bitmap : Bitmap

    init {
        val input = context?.assets?.open("mark.png")
        if (input != null) {
            bitmap = BitmapFactory.decodeStream(input)
            input.close()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas ?: return
        val paint = Paint()
        paint.style = Paint.Style.STROKE
        paint.color = Color.RED
        var rect = Rect(0, 0, bitmap.width, bitmap.height)
        canvas.drawBitmap(bitmap, rect, Rect(0, 0, 80, 200), paint)

    }
}