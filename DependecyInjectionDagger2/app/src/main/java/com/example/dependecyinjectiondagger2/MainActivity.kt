package com.example.dependecyinjectiondagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dependecyinjectiondagger2.di.component.DaggerAppComponent
import com.example.dependecyinjectiondagger2.model.Dog
import com.example.dependecyinjectiondagger2.model.Turtle
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var softwareCompany: SoftwareCompany

    /*@Inject
    lateinit var dog: Dog

    @Inject
    lateinit var dog1: Dog

    @Inject
    lateinit var turtle: Turtle

    @Inject
    lateinit var turtle1: Turtle*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.addLogAdapter(AndroidLogAdapter())

        DaggerAppComponent.builder().bindContext(applicationContext).build().inject(this)

        softwareCompany.createApp()

        /*Logger.d("injected: $dog")
        Logger.d("injected: $dog1")

        Logger.d("injected: $turtle")
        Logger.d("injected: $turtle1")*/

    }

}
