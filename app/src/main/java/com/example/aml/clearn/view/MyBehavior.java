package com.example.aml.clearn.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.aml.clearn.R;

/**
 * Created by 18624915319 on 2018/1/1.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<View>{

//    决定设置behavior关心哪个View

    public MyBehavior(Context context, AttributeSet attrs){

    }

    public MyBehavior(){}


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
//        super.layoutDependsOn(parent, child, dependency);
        return true;
    }

//    当
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        super.onDependentViewChanged(parent, child, dependency);
        child.setTranslationX(dependency.getTranslationX());
        child.setTranslationY(dependency.getTranslationY());

//        child.setTranslationZ(dependency.getTranslationZ());
        return true;
    }



}
