package com.example.welcome.view

import androidx.annotation.DrawableRes

sealed class WelcomePages(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : WelcomePages(
        image = com.example.theme.R.drawable.intro_1,
        title = "Characters",
        description = "You can access the list of characters and details."
    )

    object Second : WelcomePages(
        image = com.example.theme.R.drawable.intro_2,
        title = "Episodes",
        description = "You can access the list of episodes and details."
    )

    object Third : WelcomePages(
        image = com.example.theme.R.drawable.intro_3,
        title = "Locations",
        description = "You can access the list of locations and details."
    )
}