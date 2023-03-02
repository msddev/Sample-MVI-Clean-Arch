package com.example.characters.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import com.example.component.icon.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.component.ExtraSmallSpacer
import com.example.component.widget.SampleDivider
import com.example.model.dto.episode.EpisodeDto
import com.example.provider.NavigationProvider
import com.example.sampleframework.clickableSingle
import com.example.theme.Gray400
import com.example.theme.SampleColors
import com.example.theme.SampleTypography
import com.example.theme.cardBackgroundColor

@Composable
fun CharacterEpisodeView(dto: EpisodeDto, navigator: NavigationProvider? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(SampleColors.cardBackgroundColor)
            .clickableSingle {
                //navigator?.openEpisodeDetail(episodeId = dto.id)
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Text(
                        text = dto.name,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = SampleTypography.h6
                    )
                    Text(text = dto.episode.toString(), style = SampleTypography.subtitle1)
                }
                Icon(
                    painter = rememberVectorPainter(Icons.Default.ArrowRight),
                    contentDescription = null,
                    tint = Gray400,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
            ExtraSmallSpacer()
            SampleDivider()
        }
    }
}