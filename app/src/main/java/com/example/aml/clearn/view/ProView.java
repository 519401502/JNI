package com.example.aml.clearn.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.example.aml.clearn.R;

/**
 * Created by 18624915319 on 2018/1/6.
 */

public class ProView extends ProgressBar {

    private float color;
    private float size;

    public ProView(Context context) {
        super(context);
    }

    public ProView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(AttributeSet aAttributeSet){
        TypedArray typedArray = getContext().obtainStyledAttributes(aAttributeSet, R.styleable.progress_view);
        size = typedArray.getDimension(R.styleable.progress_view_pro_text_size, 14);
        color = typedArray.getColor(R.styleable.progress_view_pro_text_color, Color.BLUE);

    }


    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        得到当前进度条
        getProgress();
//        得到最大值
        getMax();

    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

    }
}
