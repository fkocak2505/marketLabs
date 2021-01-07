package com.fkocak.zoho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zoho.livechat.android.ZohoLiveChat
import com.zoho.salesiqembed.ZohoSalesIQ
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*ddddd.setOnClickListener {
            ZohoLiveChat.Chat.show()
        }*/
    }
}