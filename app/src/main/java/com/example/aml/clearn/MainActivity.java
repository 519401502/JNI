package com.example.aml.clearn;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.IntentService;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Property;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image_view);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View aView) {
                Dialog mSelectPhotoDialog = null;
                mSelectPhotoDialog = new Dialog(MainActivity.this);
                mSelectPhotoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_transition2, null);
                mSelectPhotoDialog.setContentView(view);
                Window window = mSelectPhotoDialog.getWindow();
                // 设置显示动画
                window.setWindowAnimations(R.style.select_photo_dialog_animstyle);
                window.setGravity(Gravity.TOP);
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams wl = window.getAttributes();
                wl.x = 0;
//                wl.y = getWindowManager().getDefaultDisplay().getHeight();
                wl.y = (int) -view.getY();
                        // 以下这两句是为了保证按钮可以水平满屏
                wl.width = WindowManager.LayoutParams.FILL_PARENT;
                wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                // 设置显示位置
                mSelectPhotoDialog.onWindowAttributesChanged(wl);
                // 设置点击外围解散
                mSelectPhotoDialog.setCanceledOnTouchOutside(false);
                mSelectPhotoDialog.show();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("~", "");
    }

    //    恢复数据
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("~");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */


}
