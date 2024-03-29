package com.example.characters.list.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.characters.list.CharactersViewModel
import com.example.model.dto.character.CharacterDto
import com.example.theme.SampleTheme
import com.example.theme.SampleTypography

@Composable
fun CharacterRow(
    viewModel: CharactersViewModel = hiltViewModel(),
    dto: CharacterDto,
    onDetailClick: () -> Unit = {}
) {

    Card(
        onClick = onDetailClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
        elevation = 8.dp
    ) {
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dto.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(com.example.theme.R.drawable.bg_thumbnail),
                error = painterResource(com.example.theme.R.drawable.bg_thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(size = 8.dp))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp, start = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    text = dto.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp),
                    style = SampleTypography.subtitle1
                )
                Text(
                    text = dto.species.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp),
                    style = SampleTypography.subtitle1
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    CharacterStatusView(dto)

                    FavoriteButton(viewModel, dto)
                }
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
fun CharacterRowPreview() {
    SampleTheme {
        CharacterRow(dto = CharacterDto.init())
    }
}