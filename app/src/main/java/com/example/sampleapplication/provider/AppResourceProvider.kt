package com.example.sampleapplication.provider

import android.content.Context
import com.example.provider.ResourceProvider

class AppResourceProvider(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}