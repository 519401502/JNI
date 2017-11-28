package com.example.aml.clearn

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button

import kotlinx.android.synthetic.main.activity_theme.*

class ThemeActivity : AppCompatActivity() {

    lateinit private var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)
        mButton = findViewById(R.id.button)
        mButton.setOnClickListener {
            setTheme(R.style.AppTheme_Night)
            recreate()
        }
    }

}
