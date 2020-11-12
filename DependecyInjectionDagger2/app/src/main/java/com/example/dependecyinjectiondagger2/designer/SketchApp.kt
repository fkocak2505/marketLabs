package com.example.dependecyinjectiondagger2.designer

import android.util.Log
import com.orhanobut.logger.Logger
import javax.inject.Inject

class SketchApp @Inject constructor() {

    fun start(){
        Logger.d("Sketch App Starting..")
    }

}