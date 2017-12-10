package com.example.aml.clearn;

import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

import com.example.aml.clearn.databinding.ActivitySixBinding;
import com.example.aml.clearn.entity.Data;
import com.example.aml.clearn.note.NoteInterface;
import com.example.aml.clearn.note.NoteParse;

public class SixActivity extends AppCompatActivity {

    @NoteInterface(value = R.id.button)
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySixBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_six);

        NoteParse.Companion.init(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View aView) {
                startActivity(new Intent(SixActivity.this, SevenActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}
