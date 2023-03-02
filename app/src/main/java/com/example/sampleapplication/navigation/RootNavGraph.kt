package com.example.sampleapplication.navigation

import com.example.characters.detail.CharactersNavGraph
import com.example.home.HomeNavGraph
import com.example.settings.SettingsNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object RootNavGraph : NavGraphSpec {
    override val route = "root"

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val startRoute = HomeNavGraph

    override val nestedNavGraphs = listOf(
        HomeNavGraph,
        CharactersNavGraph,
        SettingsNavGraph
    )
}