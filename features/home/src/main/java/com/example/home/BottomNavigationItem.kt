package com.example.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigationItem(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    CHARACTERS(
        title = com.example.theme.R.string.bottom_menu_characters,
        icon = Icons.Filled.AccountCircle
    ),
    SETTINGS(
        title = com.example.theme.R.string.bottom_menu_settings,
        icon = Icons.Filled.Settings
    );
}