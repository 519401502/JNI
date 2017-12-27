package com.example.aml.clearn

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.example.aml.clearn.adapter.ViewPagerAdapter_
import java.util.ArrayList

class LazyFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lazy_fragment)



        var viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.offscreenPageLimit = 1

        var fragments = ArrayList<android.support.v4.app.Fragment>()
        fragments.add(BlankFragment())
        fragments.add(BlankFragment2())
        val viewPagerAdapter = ViewPagerAdapter_(supportFragmentManager, fragments)
        viewPager.adapter = viewPagerAdapter
    }

}
