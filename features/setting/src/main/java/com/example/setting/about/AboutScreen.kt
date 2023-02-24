package com.example.setting.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.component.ExtraSmallSpacer
import com.example.component.MediumSpacer
import com.example.component.SmallSpacer
import com.example.component.widget.SampleToolbarWithNavIcon
import com.example.provider.NavigationProvider
import com.example.theme.SampleColors
import com.example.theme.SampleShapes
import com.example.theme.SampleTheme
import com.example.theme.SampleTypography
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AboutScreen(
    navigator: NavigationProvider
) {
    val uriHandler = LocalUriHandler.current
    val githubLink = "https://github.com/msddev"

    Scaffold(
        topBar = {
            SampleToolbarWithNavIcon(
                com.example.theme.R.string.toolbar_about_title,
                pressOnBack = {
                    navigator.navigateUp()
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    shape = SampleShapes.medium,
                    elevation = 8.dp
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = com.example.theme.R.drawable.ic_app_logo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(140.dp)
                                .clip(CircleShape)
                        )
                        MediumSpacer()
                        Text(
                            text = "Masoud Leopard",
                            style = SampleTypography.h3,
                            textAlign = TextAlign.Center
                        )
                        ExtraSmallSpacer()
                        Text(
                            text = "Android Developer",
                            style = SampleTypography.h4,
                            textAlign = TextAlign.Center
                        )
                        ExtraSmallSpacer()
                        Text(
                            text = "Developed By @msddev",
                            style = SampleTypography.h4,
                            textAlign = TextAlign.Center
                        )
                        SmallSpacer()
                        ClickableText(
                            text = AnnotatedString(text = githubLink),
                            style = SampleTypography.h6,
                            onClick = {
                                uriHandler.openUri(githubLink)
                            }
                        )
                    }
                }
            }
        }
    )
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun AboutScreenPreview() {
    SampleTheme {
        Surface(modifier = Modifier.background(SampleColors.background)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = SampleShapes.medium,
                elevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.theme.R.drawable.ic_app_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    )
                    MediumSpacer()
                    Text(
                        text = "Masoud Leopard",
                        style = SampleTypography.h3,
                        textAlign = TextAlign.Center
                    )
                    ExtraSmallSpacer()
                    Text(
                        text = "Android Developer",
                        style = SampleTypography.h4,
                        textAlign = TextAlign.Center
                    )
                    ExtraSmallSpacer()
                    Text(
                        text = "Developed By @msddev",
                        style = SampleTypography.h4,
                        textAlign = TextAlign.Center
                    )
                    SmallSpacer()
                    ClickableText(
                        text = AnnotatedString(text = "https://github.com/msddev"),
                        style = SampleTypography.h6,
                        onClick = {
                        }
                    )
                }
            }
        }
    }
}