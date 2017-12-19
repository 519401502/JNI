package com.example.aml.clearn
import android.content.Intent
import android.net.LocalSocket
import android.net.LocalSocketAddress
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.aml.mylibrary.SocketService
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.PrintWriter

class TenActivity : AppCompatActivity() {

    private lateinit var socket: LocalSocket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ten)
        startService(Intent(this, SocketService::class.java))

        val connectButton = findViewById<Button>(R.id.connect_button)
        val sendButton = findViewById<Button>(R.id.send_button)
        val content = findViewById<EditText>(R.id.edit_text)
        connectButton.setOnClickListener {
            socket = LocalSocket()
            socket.connect(LocalSocketAddress(SocketService.SERVER_SOCKET_NAME))
            val write = PrintWriter(socket.outputStream)
            write.write("服务器你好，初次连接请多多指教!\n")
            write.flush()

        }
    }
}
