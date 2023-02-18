package com.example.sampleapplication.app

import com.example.framework.base.app.CoreApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleApp : CoreApplication() {

    override fun onCreate() {
        super.onCreate()

    }
}