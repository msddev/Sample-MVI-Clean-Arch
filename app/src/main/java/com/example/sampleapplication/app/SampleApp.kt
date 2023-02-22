package com.example.sampleapplication.app

import com.example.framework.base.app.AppInitializer
import com.example.framework.base.app.CoreApplication
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class SampleApp : CoreApplication() {

    @Inject
    lateinit var initializer: AppInitializer
    override fun onCreate() {
        super.onCreate()

        initializer.init(this)
    }
}