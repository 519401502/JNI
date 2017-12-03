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
        canvas.drawRect(rect, paint)
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
        canvas.translate(0f, 0f)
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
//        Canvas画板的另一个神器 Path
        val path = Path()
//        移动path的坐标
        path.moveTo(0f, 0f)
//        从当前坐标指向某个点
        path.lineTo(100f, 100f)
//        重置最后一个点的坐标
        path.setLastPoint(100f, 100f)
//        画弧度
        var r = RectF()
        path.addArc(r, 0f, 270f)
//        判断是否为空，也就是是否包含有线段
        path.isEmpty
//        判断是否是矩形
        path.isRect(r)
//        平移path
        path.offset(100f, 10f)
//        平移path之后存储平移之后的状态，不会影响当前的状态
        path.offset(10f, 10f, Path())
//        二阶贝塞尔曲线
        path.quadTo(1f, 1f, 1f, 1f)
//        三阶贝塞尔曲线
        path.cubicTo(1f,1f,1f,1f,1f, 1f)
        /**
         * 不带r的方法是基于原点的坐标系(偏移量)，rXxx方法是基于当前点坐标系(偏移量)
         */
//        奇偶规则,填充图形围成的内部
        path.fillType = Path.FillType.EVEN_ODD
//        反奇偶规则，填充图形围成的外部
        path.fillType = Path.FillType.INVERSE_EVEN_ODD
//        非零环绕规则，最近环绕的一层
        path.fillType = Path.FillType.WINDING
//        反非零环绕规则
        path.fillType = Path.FillType.INVERSE_WINDING
//        PathMeasure 是Path的辅助类
        var measure = PathMeasure()
//        关联一个path,如果forceClosed为true则测量的是封闭状态下的长度，如果为false则测量的是原长度
        measure.setPath(path, false)
//        获取path的长度
        measure.length
//        截取path的片断, 截下的内容会添加到新path参数中，而不是替换path的内容
        measure.getSegment(0f, 100f, Path(), true)
//        跳到下一条线上，但都在一个path中
        measure.nextContour()
//        得到都一个位置的正切值
        measure.getPosTan(0f, FloatArray(10), FloatArray(10))
//        matrix 是 bitmap 的变形工具类
        var matrix = Matrix()
        matrix.setPolyToPoly(floatArrayOf(0f, 0f), 0, floatArrayOf(0f, 0f), 0, 4)
//        当一个Canvas需要使用多个Matrix时，合并Matrix的方法如下
        canvas.concat(matrix)

    }


}