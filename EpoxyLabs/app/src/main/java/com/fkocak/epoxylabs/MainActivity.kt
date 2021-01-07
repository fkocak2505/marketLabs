package com.fkocak.epoxylabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fkocak.epoxylabs.data.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = HomeController()
        messagesView.setController(controller)

        controller.allMessages = Data.messages
        controller.recentlyActive = Data.recentlyActive
    }
}