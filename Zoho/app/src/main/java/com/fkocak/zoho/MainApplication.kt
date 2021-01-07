package com.fkocak.zoho

import android.app.Application
import com.zoho.salesiqembed.ZohoSalesIQ

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        ZohoSalesIQ.init(this, getString(R.string.appKey), getString(R.string.accessKey))

    }
}