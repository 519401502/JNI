package com.example.aml.clearn.view;

/**
 * Created by xv on 2018/2/23.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2018/1/5.
 */

public class MyCanvas extends View {
    //View的大小
    private int viewSize = 800;
    private Paint mPaintLine;
    private Paint mPaint;
    private boolean isStart = false;
    private int start = 0;
    private Random random;
    public List<PointPaint> list;
    //两个随机点
    private Paint mPointPaint1, mPointPaint2;
    private final int paintWidth = 3;
    private Paint mPaintC, mPaintCC;
    //初始化角度渐变  从透明-绿色
    private Shader mShader =
            new SweepGradient(viewSize >> 1, viewSize >> 1,
                    Color.TRANSPARENT, Color.GREEN);
    private Matrix matrix = new Matrix();
    //两个随机点坐标值
    private int x1, x2;
    private int y1, y2;
    //不断改变的值  用于透明度
    private int change1;
    private int change2;
    //是否重置位置  即是否随机点坐标
    private boolean flag_reset1 = false;
    private boolean flag_reset2 = false;
    //是否开始反方向变化   从透明度255-0
    private boolean isReverse1 = false;
    private boolean isReverse2 = false;
    private int halfsize = viewSize >> 1;


    public MyCanvas(Context context) {
        super(context);
        init();
    }

    public MyCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        list = new ArrayList<>();
        initPaint();
        random = new Random();
        setBackgroundColor(Color.TRANSPARENT);
    }

    private void initPaint() {
        mPaintLine = new Paint();
        mPaintLine.setStrokeWidth(paintWidth >> 1);
        mPaintLine.setAntiAlias(true);
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setColor(0x880000ff);
        mPaintLine.setStrokeCap(Paint.Cap.ROUND);

        mPaintCC = new Paint();
        mPaintCC.setStrokeWidth(paintWidth);
        mPaintCC.setAntiAlias(true);
        mPaintCC.setStyle(Paint.Style.STROKE);
        mPaintCC.setColor(0xaa000000);
        mPaintCC.setStrokeCap(Paint.Cap.ROUND);

        mPaintC = new Paint();
        mPaintC.setStrokeWidth(paintWidth >> 1);
        mPaintC.setAntiAlias(true);
        mPaintC.setStyle(Paint.Style.STROKE);
        mPaintC.setColor(0X87872300);
        mPaintC.setStrokeCap(Paint.Cap.ROUND);

        mPaint = new Paint();
        mPaint.setColor(0x9D00ff00);
        mPaint.setAntiAlias(true);

        mPointPaint1 = new Paint();
        mPointPaint1.setStrokeWidth(2);
        mPointPaint1.setColor(0xFFFF6347);
        mPointPaint1.setAntiAlias(true);
        mPointPaint1.setAlpha(0);

        mPointPaint2 = new Paint();
        mPointPaint2.setStrokeWidth(2);
        mPointPaint2.setColor(0xffff0000);
        mPointPaint2.setAntiAlias(true);
        mPointPaint2.setAlpha(0);

        flag_reset1 = true;
        flag_reset2 = true;
        isReverse1 = false;

    }

    public void setViewSize(int size) {
        this.viewSize = size;
        mShader = new SweepGradient(viewSize >> 1, viewSize >> 1, Color.TRANSPARENT, Color.GREEN);
        setMeasuredDimension(viewSize, viewSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(viewSize + 10, viewSize + 10);
    }

    public void start() {
//        mThread = new ScanThread();
//        mThread.start();
//        isStart = true;

        if (change1 < 0) {
            isReverse1 = false;
            change1 = 0;
            flag_reset1 = true;
        }

        if (change2 < 0) {
            isReverse2 = false;
            change2 = 0;
            flag_reset2 = true;
        }

        //正方向下的 增值
        if (!isReverse2) change2 += 2;
        if (!isReverse1) change1 += 4;

        //正方向
        if (change1 >= 255) {
            isReverse1 = true;
            change1 = 255;
        }
        if (change2 >= 255) {
            isReverse2 = true;
            change2 = 255;
        }
        //
        if (isReverse1) change1 -= 8;
        if (isReverse2) change2 -= 4;

        mPointPaint1.setAlpha(change1);
        mPointPaint2.setAlpha(change2);
        if (start >= 360) start = 0;
        start += 2;

        matrix.reset();
        matrix.postRotate(start, halfsize, halfsize);

//                postInvalidate();
        postInvalidateDelayed(5);
    }

    public void stop() {
        if (isStart) {
            Thread.interrupted();
            isStart = false;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        int radius = viewSize >> 1;
        //画内圆
        canvas.drawCircle(radius, radius, radius >> 1, mPaintC);
        //画外圆
        canvas.drawCircle(radius, radius, radius - (paintWidth >> 1), mPaintCC);

        canvas.drawLine(0, radius, viewSize, radius, mPaintLine);
        canvas.drawLine(radius, 0, radius, viewSize, mPaintLine);

        mPaint.setShader(mShader);
        //设置矩阵
        canvas.concat(matrix);
        //第一种
//        canvas.drawCircle(radius, radius, radius - paintWidth, mPaint);
        //第二种
        canvas.drawArc(new RectF(0, 0, viewSize, viewSize), 0, 180, true, mPaint);
        canvas.restore();
        //画随机点
        int centerx = radius;
        int centery = radius;
        canvas.save();
        canvas.scale(0.5f + change1 / 360, 0.5f + change1 / 360);
        // canvas.drawCircle(200, 200, 8, mPointPaint1);
        canvas.restore();

        if (!isReverse1 && flag_reset1) {
            int a = random.nextInt(360);
            int d = random.nextInt(radius);
            x1 = (int) (centerx + d * (Math.cos(a * Math.PI / 180)));
            y1 = (int) (centery + d * (Math.sin(a * Math.PI / 180)));
            flag_reset1 = false;
        }
        if (!isReverse2 && flag_reset2) {
            int a = random.nextInt(360);
            int d = random.nextInt(radius);
            x2 = (int) (centerx + d * (Math.cos(a * Math.PI / 180)));
            y2 = (int) (centery + d * (Math.sin(a * Math.PI / 180)));
            flag_reset2 = false;
        }
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                //if(list.get(i).getT()!=null){
                //计算x,y值
                x1 = list.get(i).getX();
                y1 = list.get(i).getY();
                if (i == list.size() - 1) {
                    canvas.drawCircle(400 + 4 * x1, 400 + 4 * y1, 8, mPointPaint2);
                } else {
                    canvas.drawCircle(400 + 4 * x1, 400 + 4 * y1, 8, mPointPaint1);
                }
            }
        }
        start();
    }

}

