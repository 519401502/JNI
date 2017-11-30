package com.example.aml.clearn

import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.Spanned
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.aml.clearn.view.TextSpan

import kotlinx.android.synthetic.main.activity_theme.*

class ThemeActivity : AppCompatActivity() {

    lateinit private var mButton: Button
    private lateinit var mImageView: ImageView
    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)
        mButton = findViewById(R.id.button)
        mButton.setOnClickListener {
            setTheme(R.style.AppTheme_Night)
            recreate()
        }

        var spanString = SpannableString("helloworld,helloworld!helloworld,helloworld!helloworld,\" +\n" +
                "                    \"helloworld!helloworld,helloworld!")
        spanString.setSpan(TextSpan(), 0, 30,  Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        mTextView = findViewById(R.id.textView)
        mTextView.text = spanString

    }
}
