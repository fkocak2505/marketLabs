package com.example.dependecyinjectiondagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dependecyinjectiondagger2.di.component.DaggerAppComponent
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var softwareCompany: SoftwareCompany

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.addLogAdapter(AndroidLogAdapter())

        DaggerAppComponent.builder().build().inject(this)

        softwareCompany.createApp()

    }

}