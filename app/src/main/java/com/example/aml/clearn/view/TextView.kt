package com.example.aml.clearn.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View

/**
 * Created by 18624915319 on 2017/12/1.
 * 自定义View学习
 */
class TextView(context: Context?) : View(context) {

    init {
//        父布局的左侧与我的右侧距离
        right
//        父布局的上侧与我的上侧距离
        top
//        父布局的上侧与我的下侧距离
        bottom
//        父布局的左侧与我的左侧距离
        left
//        ARGB8888 四通道高精度
//        ARGB4444 四通道低精度
//        RGB565 屏幕默认模式
//        Alpha8 仅有透明通道

        /**
         * View执行流程
         * 构造器 -> onMeasure -> onSizeChanged -> onLayout -> onDraw
         */

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
//        上一次的宽度和高度
        oldh
        oldw
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        取出宽度精确值
        MeasureSpec.getSize(widthMeasureSpec)
//        取出高度精确值
        MeasureSpec.getSize(heightMeasureSpec)
//        取出宽度测量模式
        MeasureSpec.getMode(widthMeasureSpec)
//        取出高度测量模式
        MeasureSpec.getMode(heightMeasureSpec)

//        表示子View具体大小没有尺寸限制，但最大上限不能超过父布局的尺寸
        MeasureSpec.AT_MOST
//        表示父布局已经确定了子View的大小
        MeasureSpec.EXACTLY
//        表示子View没有限制
        MeasureSpec.UNSPECIFIED
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return super.onTouchEvent(event)
//        相对于自身的x, y坐标
        event.apply {
            x
            y
        }
//        相对于屏幕的x, y 坐标
        event.apply {
            rawX
            rawY
        }
        return super.onTouchEvent(event)

    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas ?: return
//        canvas画布，用于2D图形绘制
//        绘制背景颜色
        canvas.drawColor(Color.YELLOW)
//        画笔
        var paint = Paint()
//        绘制一个点
        canvas.drawPoint(0f, 0f, paint)
//        绘制多个点
        canvas.drawPoints(floatArrayOf(1f, 2f, 3f), paint)
//        绘制矩形
        var rect = RectF(0f, 0f, 0f, 0f)
        canvas.drawRect(rect ,paint)
//        绘制圆角矩形
        canvas.drawRoundRect(rect, 0f, 0f, paint)
        /**
         * 后绘制的图形会覆盖之前的复制的图层，先PS一样
         */
//        绘制椭圆
        canvas.drawOval(rect, paint)
//        绘制圆弧
        canvas.drawArc(rect, 0f, 0f, true, paint)
//        画笔描边
        paint.style = Paint.Style.STROKE
//        画笔填充
        paint.style = Paint.Style.FILL
        canvas.apply {
//            保存状态
            save()
//            回滚到上一次的保存状态
            restore()
        }

//        移动坐标，注意：相对于当前坐标，而不是屏幕
        canvas.translate(0f,0f)
//        画布缩放0.5倍
        canvas.scale(0.5f, 0.5f)
//        选装180度
        canvas.rotate(180f)
//        倾斜45度
        canvas.skew(45f, 45f)
//        获取所有的图层数量
        canvas.saveCount
//        根据图层数量，挨个弹出图层，显示在画布上
        canvas.restore()
        /**
         * android:hardwareAccelerated=”false”
         * 关闭硬件加速xml代码
         */
//        使用Picture录制
        picture()
//        绘制Bitmap,第一个Rect绘制的是Bitmap的截取大小，第二个RectF是在屏幕上显示的区域
        canvas.drawBitmap(null, Rect(), RectF(), paint)



    }

    fun picture(): Unit {
        var picature = Picture()
        var canvas = picature.beginRecording(100, 100)
        var paint = Paint()
        canvas.translate(100f, 100f)
        canvas.drawCircle(100f, 100f, 100f, paint)
        picature.endRecording()
//        将Picature保存的东西绘制出来
        picature.draw(canvas)
//        另一种将Picature绘制出来，并且不会影响Canvas
        canvas.drawPicture(picature)

    }


}