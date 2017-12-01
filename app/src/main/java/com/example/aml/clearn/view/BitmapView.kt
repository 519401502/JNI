package com.example.aml.clearn.view

import android.content.Context
import android.graphics.*
import android.view.View
import java.util.*

/**
 * Created by 18624915319 on 2017/12/1.
 */
class BitmapView(context: Context?) : View(context) {

    lateinit var bitmap : Bitmap
    private var product: Int = 1

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
        var rect = Rect((bitmap.width/13) * (product - 1), 0, (bitmap.width/13) * product, bitmap.height)
        canvas.drawBitmap(bitmap, rect, Rect(0, 0, bitmap.width/13, bitmap.height), paint)
        postDelayed({
            product = if (product <= 13) product + 1 else 1
            invalidate()
        }, 10)
    }
}