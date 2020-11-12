package com.example.dependecyinjectiondagger2

import com.example.dependecyinjectiondagger2.designer.IDesigner
import com.example.dependecyinjectiondagger2.developer.IDeveloper
import javax.inject.Inject

class SoftwareCompany @Inject constructor(private val designer: IDesigner, private val developer: IDeveloper) {

    fun createApp(){
        designer.designIt()
        developer.developIt()
    }

}