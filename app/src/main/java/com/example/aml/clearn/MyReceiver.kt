package com.example.aml.clearn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast



class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val msg = intent.getStringExtra("msg")
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
