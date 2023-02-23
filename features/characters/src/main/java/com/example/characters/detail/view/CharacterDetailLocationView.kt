package com.example.characters.detail.view

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.component.widget.SampleDivider
import com.example.model.dto.character.CharacterDto
import com.example.provider.NavigationProvider
import com.example.sampleframework.clickableSingle
import com.example.theme.*

@Composable
fun CharacterDetailLocationView(
    character: CharacterDto,
    navigator: NavigationProvider? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = com.example.theme.R.string.text_location),
            modifier = Modifier
                .padding(12.dp),
            style = SampleTypography.h6
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(SampleColors.cardBackgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                TextRow(
                    key = stringResource(id = com.example.theme.R.string.text_last_know_location),
                    value = character.origin?.name.toString()
                ) {
                    //navigator?.openLocationDetail(character.origin?.locationId.orZero())
                }
                SampleDivider()
                TextRow(
                    key = stringResource(id = com.example.theme.R.string.text_location),
                    value = character.location?.name.toString()
                ) {
                    //navigator?.openLocationDetail(character.location?.locationId.orZero())
                }
            }
        }
    }
}

@Composable
private fun TextRow(key: String, value: String, openLocationDetail: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = key,
            maxLines = 1,
            overflow = TextOverflow.Visible,
            style = SampleTypography.body2,
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd,
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .clickableSingle {
                        openLocationDetail.invoke()
                    },
                horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.End),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = value,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = SampleTypography.subtitle1,
                    textAlign = TextAlign.End
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Default.ArrowRight),
                    contentDescription = null,
                    tint = Gray400,
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun CharacterDetailLocationViewPreview() {
    SampleTheme {
        Surface(
            color = SampleColors.background
        ) {
            CharacterDetailLocationView(
                CharacterDto.init()
            )
        }
    }
}