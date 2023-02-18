package com.example.welcome

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import com.example.sampleframework.SetupSystemUi
import com.example.theme.SampleColors
import com.example.theme.SampleTheme
import com.example.welcome.navgraph.WelcomeNavGraph
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : FragmentActivity() {

    //TODO: languageProvider
    /*@Inject
    lateinit var languageProvider: LanguageProvider*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TODO: languageProvider
            /*languageProvider.setLocale(languageProvider.getLanguageCode(), LocalContext.current)*/
            WelcomeRoot()
        }
    }
}

@Composable
private fun WelcomeRoot() {
    SampleTheme {
        SetupSystemUi(rememberSystemUiController(), SampleColors.primary)
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = SampleColors.background
        ) {
            WelcomeNavGraph()
        }
    }
}