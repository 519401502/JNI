package com.example.aml.clearn

import android.animation.Animator
import android.animation.AnimatorInflater
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.aml.clearn.adapter.ViewPagerAdapter
import com.example.aml.clearn.view.ViewPagerText
import kotlinx.android.synthetic.main.activity_main2.*
import javax.xml.transform.Transformer

class Main2Activity : AppCompatActivity(){
    lateinit var animator: Animator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val viewPager = findViewById<ViewPagerText>(R.id.view_pager)
        viewPager.adapter = ViewPagerAdapter(this)
//        viewPager.setPageTransformer()
        Log.d("~", "${viewPager.offscreenPageLimit}")
        viewPager.pageMargin = 25
        viewPager.offscreenPageLimit = 3
//        viewPager.setPageTransformer(true, )
        viewPager.setPageTransformer(true, Tansformer())
        val button = findViewById<Button>(R.id.button)


        animator = AnimatorInflater.loadAnimator(this, R.animator.scale_large_text)
        animator.setTarget(button)
        button.setOnClickListener{
            viewPager.setCurrentItem(0, false)
            animator.start()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (animator.isRunning)
            animator.cancel()
    }

    open class Tansformer : ViewPager.PageTransformer{

        override fun transformPage(page: View?, position: Float) {
            page ?: return
        }

    }
}
