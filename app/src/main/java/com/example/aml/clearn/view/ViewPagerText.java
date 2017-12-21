package com.example.aml.clearn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by 18624915319 on 2017/12/20.
 */

public class ViewPagerText extends ViewPager implements ViewPager.OnPageChangeListener {

    public ViewPagerText(Context context) {
        super(context);
        init();
    }

    public ViewPagerText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
