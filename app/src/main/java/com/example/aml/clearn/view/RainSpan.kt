package com.example.aml.clearn.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance

/**
 * Created by 18624915319 on 2017/11/30.
 */
class RainSpan : CharacterStyle(), UpdateAppearance {

    override fun updateDrawState(aTextPaint: TextPaint?) {
        aTextPaint ?: return
        aTextPaint.style = Paint.Style.FILL
        var lists: IntArray = IntArray(10)
        lists[0] = Color.WHITE
        lists[1] = Color.YELLOW
        lists[0] = Color.RED
        lists[1] = Color.CYAN
        lists[0] = Color.WHITE
        lists[1] = Color.YELLOW
        lists[0] = Color.WHITE
        lists[1] = Color.YELLOW

        var shared = LinearGradient(0.0f, 0.0f, 0.0f, aTextPaint.getTextSize() * lists.size,lists, null,
                Shader.TileMode.MIRROR)
        val matrix = Matrix()
        matrix.setRotate(90f)
        shared.setLocalMatrix(matrix)
        aTextPaint.shader = shared


    }
}