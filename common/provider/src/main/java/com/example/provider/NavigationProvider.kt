package com.example.provider

interface NavigationProvider {
    fun openCharacterDetail(characterId: Int)
    fun navigateUp()
}