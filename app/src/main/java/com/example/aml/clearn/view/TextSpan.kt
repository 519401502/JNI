package com.example.aml.clearn.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.style.ReplacementSpan

/**
 * Created by 18624915319 on 2017/11/30.
 */
class TextSpan() : ReplacementSpan() {

    private var mPaint: Paint = Paint()
    private var mWidth: Float = 0f

    init {
        mPaint.also {
            it.style = Paint.Style.STROKE
            it.color = Color.BLUE
        }
    }

    override fun draw(canvas: Canvas?, char: CharSequence?, start: Int, end: Int, x: Float, top: Int, y: Int, button: Int, aPaint: Paint?) {
        aPaint ?: return
        canvas ?: return
        canvas.drawRect(x, top.toFloat(), x + mWidth, button.toFloat(), mPaint);
        canvas.drawText(char, start, end, x.toFloat(), y.toFloat(), mPaint)
    }

    override fun getSize(aPaint: Paint?, p1: CharSequence?, p2: Int, p3: Int, p4: Paint.FontMetricsInt?): Int {
        aPaint ?: return 0
        mWidth = aPaint.measureText(p1, p2, p3).toInt().toFloat()
        return mWidth.toInt()
    }

}