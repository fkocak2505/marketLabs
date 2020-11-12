package com.example.dependecyinjectiondagger2.di.component

import com.example.dependecyinjectiondagger2.MainActivity
import com.example.dependecyinjectiondagger2.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}