package com.example.sampleapplication.provider

import androidx.navigation.NavController
import com.example.characters.detail.destinations.CharacterDetailScreenDestination
import com.example.provider.NavigationProvider
import com.example.setting.destinations.AboutScreenDestination
import com.example.setting.destinations.LanguageScreenDestination
import com.example.setting.destinations.TermsAndPrivacyScreenDestination

class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {

    override fun openCharacterDetail(characterId: Int) {
        navController.navigate(CharacterDetailScreenDestination(characterId).route)
    }

    override fun openTermAndPrivacy() {
        navController.navigate(TermsAndPrivacyScreenDestination.route)
    }

    override fun openAppLanguage() {
        navController.navigate(LanguageScreenDestination.route)
    }

    override fun openAbout() {
        navController.navigate(AboutScreenDestination.route)
    }

    override fun navigateUp() {
        navController.navigateUp()
    }
}