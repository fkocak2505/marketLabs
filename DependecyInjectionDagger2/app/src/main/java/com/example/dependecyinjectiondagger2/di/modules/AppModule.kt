package com.example.dependecyinjectiondagger2.di.modules

import com.example.dependecyinjectiondagger2.SoftwareCompany
import com.example.dependecyinjectiondagger2.designer.UiDesigner
import com.example.dependecyinjectiondagger2.developer.AndroidDeveloper
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    internal fun provideSoftwareCompany(uiDesigner: UiDesigner, androidDeveloper: AndroidDeveloper): SoftwareCompany {
        return SoftwareCompany(uiDesigner, androidDeveloper)
    }

}