package com.example.characters.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.characters.detail.view.CharacterDetailContent
import com.example.component.widget.EmptyView
import com.example.component.widget.ErrorView
import com.example.component.widget.LoadingView
import com.example.component.widget.SampleToolbarWithNavIcon
import com.example.framework.base.mvi.BaseViewState
import com.example.framework.extension.cast
import com.example.provider.NavigationProvider
import com.example.theme.SampleTheme
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun CharacterDetailScreen(
    id: Int = 0,
    viewModel: CharacterDetailViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    val uiState by viewModel.uiState.collectAsState()

    CharacterDetailBody(
        pressOnBack = {
            navigator.navigateUp()
        }
    ) {
        when (uiState) {
            is BaseViewState.Data -> CharacterDetailContent(
                data = uiState.cast<BaseViewState.Data<CharacterDetailViewState>>().value,
                navigator = navigator
            )
            is BaseViewState.Empty -> EmptyView()
            is BaseViewState.Error -> ErrorView(
                e = uiState.cast<BaseViewState.Error>().throwable,
                action = {
                    viewModel.onTriggerEvent(CharacterDetailEvent.LoadDetail(id))
                }
            )
            is BaseViewState.Loading -> LoadingView()
        }
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onTriggerEvent(CharacterDetailEvent.LoadDetail(id))
    })
}

@Composable
private fun CharacterDetailBody(
    pressOnBack: () -> Unit = {},
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            SampleToolbarWithNavIcon(
                com.example.theme.R.string.toolbar_character_detail_title,
                pressOnBack = pressOnBack
            )
        },
        content = { pageContent.invoke(it) }
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun CharacterDetailScreenPreview() {
    SampleTheme {
        Surface {
            CharacterDetailBody {

            }
        }
    }
}