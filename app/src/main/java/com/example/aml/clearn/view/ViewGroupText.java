package com.example.aml.clearn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by 18624915319 on 2017/12/8.
 */

/**
 * 流式布局
 */
public class ViewGroupText extends ViewGroup {

    public ViewGroupText(Context context) {
        super(context);
    }

    public ViewGroupText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //    确定自身的LayoutParams

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(super.generateLayoutParams(p));
    }

    private int widthSpec = 0;
    private int heightSpec = 0;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthSpec = widthMeasureSpec;
        heightSpec = heightMeasureSpec;
//        拿到规格参数
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpec = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpec = MeasureSpec.getMode(heightMeasureSpec);


//        计算出所有子View的尺寸
        measureChildren(widthMeasureSpec, heightMeasureSpec);
//        得到子View的总数
        int count = getChildCount();
//        ViewGroup的宽和高
        int groupHeight = 0;

        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            int childHeight = view.getMeasuredHeight();
            LayoutParams params = view.getLayoutParams();
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(params);
            groupHeight += childHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            Log.d("~", "子 View 高 = " + childHeight + "");
        }

//        设置ViewGroup的尺寸大小
        setMeasuredDimension(width,
                heightSpec == MeasureSpec.EXACTLY ? height : groupHeight);
    }

    //    定位子View
    @Override
    protected void onLayout(boolean aB, int l, int t, int r, int b) {
        int count = getChildCount();
        int cl = 0, ct = 0, cr = 0, cb = 0;
        int suml = 0, sumt = 0;
        int pWidth = getMeasuredWidth();
        measureChildren(widthSpec, heightSpec);
        for (int i = 0; i < count; i++) {
//            给子View定位
            View view = getChildAt(i);
//            measureChild(view, );
            LayoutParams params = view.getLayoutParams();
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(params);
            cl = suml + marginLayoutParams.leftMargin;
            ct = sumt + marginLayoutParams.topMargin;
            cb = marginLayoutParams.topMargin + view.getMeasuredHeight();
            cr = marginLayoutParams.leftMargin + view.getMeasuredWidth();
            if (cr > pWidth){
                cr = marginLayoutParams.leftMargin;
                cl = suml = marginLayoutParams.leftMargin + view.getMeasuredWidth();
            }
//            子View定位
            view.layout(cl, ct, cr, cb);
            suml = cr + marginLayoutParams.rightMargin;
            sumt = ct + view.getMeasuredHeight()  + marginLayoutParams.bottomMargin;
            Log.d("~", "onLayout View 高 = " + view.getMeasuredHeight() + "");

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
