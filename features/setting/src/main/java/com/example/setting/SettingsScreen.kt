package com.example.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.provider.NavigationProvider
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    navigator: NavigationProvider
) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green))
}