package com.example.aml.clearn

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.aml.clearn.entity.Data

class DataBindActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var action : ViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_bind)
        val data = Data("徐会闯", 22)
        action.setVariable(BR.data2, data)
//        action.setVariable(BR.data2, data)
    }
}
