package com.example.sampleapplication.app

import com.example.framework.base.app.NetworkConfig
import com.example.sampleapplication.BuildConfig

class SampleNetworkConfig : NetworkConfig() {
    override fun baseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun timeOut(): Long {
        return 30L
    }

    override fun isDev(): Boolean {
        return BuildConfig.DEBUG
    }
}