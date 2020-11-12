package com.example.dependecyinjectiondagger2.di.component

import android.content.Context
import com.example.dependecyinjectiondagger2.MainActivity
import com.example.dependecyinjectiondagger2.di.modules.AppModule
import com.example.dependecyinjectiondagger2.di.scopes.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
/*@ApplicationScope*/
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    abstract class Builder{
        @BindsInstance
        abstract fun bindContext(context: Context): Builder
        abstract fun build(): AppComponent
    }

}