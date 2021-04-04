package com.rygital.posts

import android.app.Application
import com.rygital.posts.di.ApplicationComponent
import com.rygital.posts.di.ApplicationComponentHolder
import com.rygital.posts.di.DaggerApplicationComponent
import com.rygital.posts.utils.LoggingTree
import timber.log.Timber

class DemoApplication : Application(), ApplicationComponentHolder {

    override lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(LoggingTree())
        }

        applicationComponent = DaggerApplicationComponent.create()
    }
}
