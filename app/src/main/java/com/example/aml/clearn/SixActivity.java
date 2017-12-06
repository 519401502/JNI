package com.example.aml.clearn;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aml.clearn.databinding.ActivitySixBinding;
import com.example.aml.clearn.entity.Data;

public class SixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_six);
        ActivitySixBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_six);
        Data data = new Data("", 22);
//        binding.setVariable(BR.data, data);
        binding.setData(data);

    }
}
