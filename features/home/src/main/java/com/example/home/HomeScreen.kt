package com.example.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.characters.list.CharactersScreen
import com.example.provider.NavigationProvider
import com.example.settings.SettingsScreen
import com.example.theme.RalewayFonts
import com.example.theme.SampleColors
import com.example.theme.selectedBottomItemColor
import com.example.theme.unselectedBottomItemColor
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: NavigationProvider
) {
    val scaffoldState = rememberScaffoldState()

    // In higher-order function, the parameter that is defined as function must have a type (R, T) -> R,
    // so it accepts a function that takes two arguments of types R and T and returns a value of type R.
    val (currentBottomTab, setCurrentBottomTab) = rememberSaveable {
        mutableStateOf(BottomNavigationItem.CHARACTERS) // Default selected tab
    }

    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    Crossfade(currentBottomTab) { bottomTab ->
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = { HomeBottomNavigation(bottomTab, setCurrentBottomTab) },
            content = {
                val modifier = Modifier.padding(it)
                when (bottomTab) {
                    BottomNavigationItem.CHARACTERS -> CharactersScreen(
                        modifier = modifier,
                        navigator = navigator,
                        bottomSheetState = bottomSheetState
                    )
                    BottomNavigationItem.SETTINGS -> SettingsScreen(
                        modifier = modifier,
                        navigator = navigator
                    )
                }
            }
        )
    }
}

@Composable
private fun HomeBottomNavigation(
    bottomTab: BottomNavigationItem,
    setCurrentBottomTab: (BottomNavigationItem) -> Unit
) {
    val bottomBarHeight = dimensionResource(id = com.example.theme.R.dimen.bottom_bar_height)
    val pages = BottomNavigationItem.values()

    BottomNavigation(
        backgroundColor = SampleColors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsHeight(bottomBarHeight)
    ) {
        pages.forEach { page ->
            val selected = page == bottomTab
            val selectedLabelColor = if (selected) {
                selectedBottomItemColor
            } else {
                unselectedBottomItemColor
            }
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = rememberVectorPainter(image = page.icon),
                        contentDescription = stringResource(page.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(page.title),
                        color = selectedLabelColor,
                        fontSize = dimensionResource(id = com.example.theme.R.dimen.bottom_bar_item_text).value.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = RalewayFonts
                    )
                },
                selected = selected,
                onClick = {
                    setCurrentBottomTab.invoke(page)
                },
                selectedContentColor = selectedBottomItemColor,
                unselectedContentColor = unselectedBottomItemColor,
                alwaysShowLabel = true,
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}