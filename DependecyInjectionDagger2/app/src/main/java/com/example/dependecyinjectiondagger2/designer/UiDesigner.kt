package com.example.dependecyinjectiondagger2.designer

import com.example.dependecyinjectiondagger2.common.Computer
import com.orhanobut.logger.Logger
import javax.inject.Inject

class UiDesigner @Inject constructor(private val computer: Computer, private val sketchApp: SketchApp) : IDesigner{

    override fun designIt() {
        computer.start()
        sketchApp.start()
        Logger.d("UI Designer Start coding..")
    }
}