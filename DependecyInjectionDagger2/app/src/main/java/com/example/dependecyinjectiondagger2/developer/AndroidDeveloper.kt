package com.example.dependecyinjectiondagger2.developer

import com.example.dependecyinjectiondagger2.common.Computer
import com.orhanobut.logger.Logger
import javax.inject.Inject

class AndroidDeveloper @Inject constructor(private val computer: Computer, private val androidStudio: AndroidStudio) : IDeveloper {

    override fun developIt() {
        computer.start()
        androidStudio.start()
        Logger.d("Android Developer Start coding..")
    }

}