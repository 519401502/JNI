package com.example.aml.clearn.note;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xv on 2018/2/21.
 */

public class ManagerText extends RecyclerView.LayoutManager {

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    /**
     * onLayoutChildren是LayoutManager的入口
     * @param recycler
     * @param state
     */
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        if (state.isPreLayout() || getItemCount() <= 0){
            return;
        }
        //缓存所有item
        detachAndScrapAttachedViews(recycler);
        //拿到第一个View
        View view = recycler.getViewForPosition(0);
        //测量所有View的尺寸
        measureChildWithMargins(view, 0, 0);
//        得到一个view的宽和高
        int itemWidth = getDecoratedMeasuredWidth(view);
        int itemHeight = getDecoratedMeasuredHeight(view);



    }
}
