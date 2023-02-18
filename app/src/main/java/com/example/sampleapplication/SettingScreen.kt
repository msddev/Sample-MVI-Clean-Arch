package com.example.sampleapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator

@Destination
@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    resultNavigator: ResultBackNavigator<Unit>
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Button(onClick = {
            resultNavigator.navigateBack()
        }) {
            Text(text = "Back!")
        }
    }
}