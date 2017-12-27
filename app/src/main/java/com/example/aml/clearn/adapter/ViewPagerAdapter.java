package com.example.aml.clearn.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aml.clearn.R;
import com.example.aml.clearn.XApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18624915319 on 2017/12/20.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Integer> lists;

    public ViewPagerAdapter(Context aContext){
        this.mContext = aContext;
        lists = new ArrayList<>();
        lists.add(R.drawable.image2);
        lists.add(R.drawable.image2);
        lists.add(R.drawable.image2);
        lists.add(R.drawable.image2);
        lists.add(R.drawable.image2);
        lists.add(R.drawable.image2);
        lists.add(R.drawable.image1);
        lists.add(R.drawable.image2);
        lists.add(R.drawable.image3);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
//        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), lists.get(position)));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//        if (object instanceof ImageView){
//            Drawable drawable =  ((ImageView) object).getDrawable();
//            if (drawable != null && drawable instanceof BitmapDrawable) {
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//                if (bitmap != null && !bitmap.isRecycled()) {
//                    bitmap.recycle();
//                }
//            }
//        }
//        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        return "hello word";
    }

    @Override
    public float getPageWidth(int position) {
        super.getPageWidth(position);
        return 0.3f;
    }
}
