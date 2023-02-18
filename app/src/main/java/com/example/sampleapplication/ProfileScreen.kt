package com.example.sampleapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sampleapplication.destinations.SettingScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true) // sets this as the start destination of the default nav graph
@Destination
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Button(onClick = {
            navigator.navigate(
                SettingScreenDestination()
            )
        }) {
            Text(text = "Click!")
        }
    }
}