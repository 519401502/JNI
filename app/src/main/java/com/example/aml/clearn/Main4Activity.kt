package com.example.aml.clearn

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.support.annotation.RequiresApi
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.aml.clearn.note.DialogFragmentText
import com.sun.jna.StringArray
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import java.util.*
import kotlin.collections.ArrayList


class Main4Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<String>()

    lateinit var image: ImageView

    init {
        mList.apply {
            add("1")
            add("2")
            add("3")
            add("1")
            add("2")
            add("3")
            add("1")
            add("2")
            add("3")
            add("1")
            add("2")
            add("3")
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val image = findViewById<ImageView>(R.id.image)
        image.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }
        image.setImageResource(R.drawable.image3)
        recyclerView.layoutManager = LinearLayoutManager(this)



    }

    class MyView(context: Context?) : View(context) {

        init {

        }

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            if (canvas == null){
                return
            }
            var text : TextPaint = TextPaint()
            text.color = Color.BLUE
            text.style = Paint.Style.FILL
            text.textSize = 50F
            val message = "paint,draw paint指用颜色画,如油画颜料、水彩或者水墨画,而draw 通常指用铅笔、钢笔或者粉笔画,后者一般并不涂上颜料。两动词的相应名词分别为p"
        }


    }

}
