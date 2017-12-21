package com.example.aml.mylibrary

import android.app.IntentService
import android.content.Intent
import android.net.LocalServerSocket
import android.os.Handler
import android.os.Message
import android.os.Messenger
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader

class SocketService : IntentService("") {

    companion object {
        val SERVER_SOCKET_NAME = "com.example.aml.mylibrary.SocketService"
    }

    override fun onHandleIntent(p0: Intent?) {
        val serviceSocket = LocalServerSocket(SERVER_SOCKET_NAME)
        Log.d("~", "服务器创建成功，等待客户端连接...")
        val socket = serviceSocket.accept()
        Log.d("~", "客户端成功连接...")
        val input = socket.inputStream
        val reader = BufferedReader(InputStreamReader(input))
        Log.d("~", reader.readLine())
    }
}
