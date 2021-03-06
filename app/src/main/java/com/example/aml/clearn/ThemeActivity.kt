package com.example.aml.clearn

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import android.support.v4.app.JobIntentService
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.aml.clearn.view.RainSpan
import com.example.aml.clearn.view.TextSpan

import kotlinx.android.synthetic.main.activity_theme.*

class ThemeActivity : AppCompatActivity() {

    private lateinit var mButton: Button
    private lateinit var mImageView: ImageView
    private lateinit var mTextView: TextView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

        var spanString = SpannableString("helloworld,helloworld!helloworld,helloworld!helloworld,\" +\n" +
                "                    \"helloworld!helloworld,helloworld!")
        spanString.setSpan(RainSpan(), 0, 10,  Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        mTextView = findViewById(R.id.textView)
        mTextView.text = spanString

    }


}
