package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import com.b1nd.dodam.designsystem.tokens.TypographyTokens

@Immutable
data class DodamTypography(
    val headline1: TextStyle = TypographyTokens.Headline1,
    val headline2: TextStyle = TypographyTokens.Headline2,
    val headline3: TextStyle = TypographyTokens.Headline3,
    val title1: TextStyle = TypographyTokens.Title1,
    val title2: TextStyle = TypographyTokens.Title2,
    val title3: TextStyle = TypographyTokens.Title3,
    val body1Strong: TextStyle = TypographyTokens.Body1Strong,
    val body1Normal: TextStyle = TypographyTokens.Body1Normal,
    val body2Strong: TextStyle = TypographyTokens.Body2Strong,
    val body2Normal: TextStyle = TypographyTokens.Body2Normal,
    val body3Normal: TextStyle = TypographyTokens.Body3Normal,
    val body3Strong: TextStyle = TypographyTokens.Body3Strong,
    val label1: TextStyle = TypographyTokens.Label1,
    val label2: TextStyle = TypographyTokens.Label2,
)

internal val LocalDodamTypography = staticCompositionLocalOf { DodamTypography() }