package com.example.aml.clearn.view

import android.annotation.SuppressLint
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
        val input = context?.assets?.open("image2.jpg")
        if (input != null) {
            bitmap = BitmapFactory.decodeStream(input)
            input.close()
        }
    }


    override fun onDraw(canvas: Canvas?) {
        canvas ?: return super.onDraw(canvas)
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        paint.isAntiAlias = true
//        var rect = Rect((bitmap.width/13) * (product - 1), 0, (bitmap.width/13) * product, bitmap.height)
//        canvas.drawBitmap(bitmap, rect, Rect(0, 0, bitmap.width/13, bitmap.height), paint)

//        var m = Matrix()
//        canvas.matrix = m

        var rectf = RectF(0f, 0f, 100f, 100f)
        var shared = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        shared.setLocalMatrix(m)
        paint.shader = shared
        var path = Path()


        path.addRect(rectf, Path.Direction.CW)

//        path.addCircle(100f, 100f, 50f, Path.Direction.CW)
        path.close()
        canvas.drawPath(path, paint)
//        canvas.drawRoundRect(RectF(0f, 0f, 80f, 200f), 10f, 10f, paint)
    }
}