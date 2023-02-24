package com.example.provider

interface NavigationProvider {
    fun openCharacterDetail(characterId: Int)
    fun openTermAndPrivacy()
    fun openAppLanguage()
    fun openAbout()
    fun navigateUp()
}