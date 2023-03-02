@file:Suppress("LongMethod")

package com.example.settings.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import com.example.component.icon.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.component.widget.SampleDivider
import com.example.component.widget.ThemeSwitch
import com.example.framework.extension.appVersion
import com.example.provider.NavigationProvider
import com.example.sampleframework.clickableSingle
import com.example.settings.SettingsViewModel
import com.example.theme.Gray400
import com.example.theme.SampleTheme
import com.example.theme.SampleTypography

@Composable
fun SettingsContent(
    viewModel: SettingsViewModel = hiltViewModel(),
    checkedState: MutableState<Boolean>,
    navigator: NavigationProvider? = null
) {
    val context = LocalContext.current
    val version = context.appVersion()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ConstraintLayout(
                modifier = Modifier
            ) {
                val (
                    lblThemeMode,
                    switchThemeMode,
                    viewDivider1,
                    lblRateApp,
                    viewDivider2,
                    lblShareApp,
                    viewDivider3,
                    lblTermAndPrivacy,
                    viewDivider4,
                    lblAppLanguage,
                    viewDivider5,
                    lblAbout,
                    lblAppVersion,
                    viewDivider6,
                    tvAppVersion
                ) = createRefs()

                Text(
                    text = stringResource(id = com.example.theme.R.string.text_theme_mode),
                    style = SampleTypography.body2,
                    modifier = Modifier
                        .constrainAs(lblThemeMode) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(16.dp)
                )

                AndroidView(
                    factory = { context ->
                        ThemeSwitch(context).apply {
                            isChecked = checkedState.value
                            setOnCheckedChangeListener { _, isChecked ->
                                checkedState.value = isChecked
                                viewModel.saveThemeMode(isChecked)
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp)
                        .constrainAs(switchThemeMode) {
                            top.linkTo(lblThemeMode.bottom)
                            bottom.linkTo(lblThemeMode.bottom)
                            end.linkTo(parent.end)
                        }
                )

                SampleDivider(
                    modifier = Modifier
                        .constrainAs(viewDivider1) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblThemeMode.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Text(
                    text = stringResource(id = com.example.theme.R.string.text_rate_app),
                    style = SampleTypography.body2,
                    modifier = Modifier
                        .constrainAs(lblRateApp) {
                            top.linkTo(lblThemeMode.bottom)
                            start.linkTo(parent.start)
                        }
                        .padding(16.dp)
                )

                SampleDivider(
                    modifier = Modifier
                        .constrainAs(viewDivider2) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblRateApp.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Text(
                    text = stringResource(id = com.example.theme.R.string.text_share_app),
                    style = SampleTypography.body2,
                    modifier = Modifier
                        .constrainAs(lblShareApp) {
                            top.linkTo(viewDivider2.bottom)
                            start.linkTo(parent.start)
                        }
                        .padding(16.dp)
                )

                SampleDivider(
                    modifier = Modifier
                        .constrainAs(viewDivider3) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblShareApp.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Row(
                    modifier = Modifier
                        .constrainAs(lblTermAndPrivacy) {
                            top.linkTo(viewDivider3.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            navigator?.openTermAndPrivacy()
                        }
                        .padding(16.dp)
                ) {
                    Text(
                        text = stringResource(id = com.example.theme.R.string.text_term_and_privacy),
                        style = SampleTypography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }

                SampleDivider(
                    modifier = Modifier
                        .constrainAs(viewDivider4) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblTermAndPrivacy.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Row(
                    modifier = Modifier
                        .constrainAs(lblAppLanguage) {
                            top.linkTo(viewDivider4.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            navigator?.openAppLanguage()
                        }
                        .padding(16.dp)
                ) {
                    Text(
                        text = stringResource(id = com.example.theme.R.string.text_app_language),
                        style = SampleTypography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }

                SampleDivider(
                    modifier = Modifier
                        .constrainAs(viewDivider5) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblAppLanguage.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Row(
                    modifier = Modifier
                        .constrainAs(lblAbout) {
                            top.linkTo(viewDivider5.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            navigator?.openAbout()
                        }
                        .padding(16.dp)
                ) {
                    Text(
                        text = stringResource(id = com.example.theme.R.string.text_about),
                        style = SampleTypography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }

                SampleDivider(
                    modifier = Modifier
                        .constrainAs(viewDivider6) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblAbout.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Text(
                    text = stringResource(id = com.example.theme.R.string.text_app_version),
                    style = SampleTypography.body2,
                    modifier = Modifier
                        .constrainAs(lblAppVersion) {
                            top.linkTo(viewDivider6.bottom)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                        }
                        .padding(16.dp)
                )

                Text(
                    text = version,
                    style = SampleTypography.subtitle1,
                    modifier = Modifier
                        .constrainAs(tvAppVersion) {
                            top.linkTo(lblAppVersion.top)
                            bottom.linkTo(lblAppVersion.bottom)
                            end.linkTo(parent.end)
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsContentPreview() {
    SampleTheme {
        val checkedState = remember {
            mutableStateOf(true)
        }
        SettingsContent(checkedState = checkedState)
    }
}