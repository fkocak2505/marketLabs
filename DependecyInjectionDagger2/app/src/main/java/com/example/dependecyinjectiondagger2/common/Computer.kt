package com.example.dependecyinjectiondagger2.common

import android.util.Log
import com.orhanobut.logger.Logger
import javax.inject.Inject

class Computer @Inject constructor() {

    fun start(){
        Logger.d("Computer Starting..")
    }

}