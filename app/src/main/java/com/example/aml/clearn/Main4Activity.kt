package com.example.aml.clearn

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.example.aml.clearn.note.DialogFragmentText
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit





class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build()
        var api : API = retrofit.create(API::class.java)

    }

}
