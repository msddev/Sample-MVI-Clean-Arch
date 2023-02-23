package com.example.characters.detail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.characters.detail.CharacterDetailViewState
import com.example.provider.NavigationProvider
import com.example.theme.SampleTypography

@Composable
fun CharacterDetailContent(data: CharacterDetailViewState, navigator: NavigationProvider? = null) {
    LazyColumn {
        data.character?.let { character ->
            item("header") {
                CharacterDetailHeaderView(character = character)
            }

            item("contentInfo") {
                CharacterDetailInfoView(character = character)
            }

            item("contentLocation") {
                CharacterDetailLocationView(character = character, navigator = navigator)
            }

            if (character.episodeDtoList.isNotEmpty()) {
                item("contentEpisode") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = com.example.theme.R.string.text_episodes),
                            modifier = Modifier
                                .padding(12.dp),
                            style = SampleTypography.h6
                        )
                        character.episodeDtoList.forEach {
                            CharacterEpisodeView(dto = it, navigator = navigator)
                        }
                    }
                }
            }
        }
    }
}