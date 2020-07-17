package com.arthlimchiu.daggerworkshop

import android.app.Application
import com.arthlimchiu.daggerworkshop.dagger.AppComponent
import com.arthlimchiu.daggerworkshop.dagger.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}

lateinit var appComponent:AppComponent