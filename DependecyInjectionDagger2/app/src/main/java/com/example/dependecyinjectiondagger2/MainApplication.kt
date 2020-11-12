package com.example.dependecyinjectiondagger2

import android.app.Application

class MainApplication: Application() {

    companion object{
        var dogCount = 0
        var turtleCount = 0
    }

    override fun onCreate() {
        super.onCreate()
    }
}