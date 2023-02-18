package com.example.splash

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import com.example.framework.extension.launchActivity

class SplashActivity : FragmentActivity() {

    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)
        /*lifecycleScope.launchWhenCreated {
            viewModel.startWelcome.collectLatest {
                delay(3000)
                if (it) navigateWelcomeActivity() else navigateMainActivity()
            }
        }*/
    }

    private fun navigateMainActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.example.sampleapplication.navigation.MainActivity"
        ).also {
            finish()
        }
    }

    private fun navigateWelcomeActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.developersancho.welcome.WelcomeActivity"
        ).also {
            finish()
        }
    }
}