package com.example.aml.clearn;

import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
//        setContentView(R.layout.activity_six);
        ActivitySixBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_six);
        Data data = new Data("", 22);
//        binding.setVariable(BR.data, data);
        binding.setData(data);
        ViewStub stub = findViewById(R.id.view_stub);
        stub.inflate();
//        text(this);
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null) {
            Uri uri = intent.getData();
            if (uri != null && uri.getQueryParameter("pid") != null) {
                String s = uri.getQueryParameter("pid");
                Toast.makeText(this, s, Toast.LENGTH_LONG).show();
            }
        }
        NoteParse.Companion.init(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View aView) {
                Toast.makeText(SixActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void text(View aView){

    }
}
