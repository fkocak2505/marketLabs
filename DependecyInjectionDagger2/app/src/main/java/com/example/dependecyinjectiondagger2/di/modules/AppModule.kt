package com.example.dependecyinjectiondagger2.di.modules

import android.content.Context
import android.widget.Toast
import com.example.dependecyinjectiondagger2.MainApplication.Companion.dogCount
import com.example.dependecyinjectiondagger2.MainApplication.Companion.turtleCount
import com.example.dependecyinjectiondagger2.SoftwareCompany
import com.example.dependecyinjectiondagger2.designer.UiDesigner
import com.example.dependecyinjectiondagger2.developer.AndroidDeveloper
import com.example.dependecyinjectiondagger2.model.Dog
import com.example.dependecyinjectiondagger2.model.Turtle
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    internal fun provideSoftwareCompany(
        context: Context,
        uiDesigner: UiDesigner,
        androidDeveloper: AndroidDeveloper
    ): SoftwareCompany {
        Toast.makeText(context, "I'm using @BindInstance", Toast.LENGTH_LONG)
            .show()
        return SoftwareCompany(uiDesigner, androidDeveloper)
    }

    @Provides
    internal fun provideDog(): Dog = Dog("Snoopy", dogCount++)

    @Provides
    @Singleton
    /*@ApplicationScope*/
    internal fun provideTurtle(): Turtle = Turtle("Turtle", turtleCount++)


}

