package com.example.settings.termandprivacy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.component.widget.SampleToolbarWithNavIcon
import com.example.provider.NavigationProvider
import com.example.sampleframework.htmltext.HtmlText
import com.example.theme.SampleColors
import com.example.theme.SampleTypography
import com.example.theme.cardBackgroundColor
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun TermsAndPrivacyScreen(
    navigator: NavigationProvider
) {
    Scaffold(
        topBar = {
            SampleToolbarWithNavIcon(
                com.example.theme.R.string.toolbar_terms_and_privacy_title,
                pressOnBack = {
                    navigator.navigateUp()
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .background(SampleColors.cardBackgroundColor)
            ) {
                HtmlText(
                    text = termsAndConditions.plus(privacyPolicy),
                    modifier = Modifier
                        .padding(12.dp)
                        .verticalScroll(rememberScrollState()),
                    style = SampleTypography.h4
                )
            }
        }
    )
}