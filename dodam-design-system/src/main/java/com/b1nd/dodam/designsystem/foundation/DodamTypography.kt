package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import com.b1nd.dodam.designsystem.tokens.TypographyTokens

@Immutable
data class DodamTypography(
    val title1Bold: TextStyle = TypographyTokens.Title1.Bold,
    val title1Medium: TextStyle = TypographyTokens.Title1.Medium,
    val title1Regular: TextStyle = TypographyTokens.Title1.Regular,
    val title2Bold: TextStyle = TypographyTokens.Title2.Bold,
    val title2Medium: TextStyle = TypographyTokens.Title2.Medium,
    val title2Regular: TextStyle = TypographyTokens.Title2.Regular,
    val title3Bold: TextStyle = TypographyTokens.Title3.Bold,
    val title3Medium: TextStyle = TypographyTokens.Title3.Medium,
    val title3Regular: TextStyle = TypographyTokens.Title3.Regular,
    val headlineBold: TextStyle = TypographyTokens.Headline.Bold,
    val headlineMedium: TextStyle = TypographyTokens.Headline.Medium,
    val headlineRegular: TextStyle = TypographyTokens.Headline.Regular,
    val heading1Bold: TextStyle = TypographyTokens.Heading1.Bold,
    val heading1Medium: TextStyle = TypographyTokens.Heading1.Medium,
    val heading1Regular: TextStyle = TypographyTokens.Heading1.Regular,
    val heading2Bold: TextStyle = TypographyTokens.Heading2.Bold,
    val heading2Medium: TextStyle = TypographyTokens.Heading2.Medium,
    val heading2Regular: TextStyle = TypographyTokens.Heading2.Regular,
    val body1Bold: TextStyle = TypographyTokens.Body1.Bold,
    val body1Medium: TextStyle = TypographyTokens.Body1.Medium,
    val body1Regular: TextStyle = TypographyTokens.Body1.Regular,
    val body2Bold: TextStyle = TypographyTokens.Body2.Bold,
    val body2Medium: TextStyle = TypographyTokens.Body2.Medium,
    val body2Regular: TextStyle = TypographyTokens.Body2.Regular,
    val labelBold: TextStyle = TypographyTokens.Label.Bold,
    val labelMedium: TextStyle = TypographyTokens.Label.Medium,
    val labelRegular: TextStyle = TypographyTokens.Label.Regular,
    val caption1Bold: TextStyle = TypographyTokens.Caption1.Bold,
    val caption1Medium: TextStyle = TypographyTokens.Caption1.Medium,
    val caption1Regular: TextStyle = TypographyTokens.Caption1.Regular,
    val caption2Bold: TextStyle = TypographyTokens.Caption2.Bold,
    val caption2Medium: TextStyle = TypographyTokens.Caption2.Medium,
    val caption2Regular: TextStyle = TypographyTokens.Caption2.Regular,
)

internal val LocalDodamTypography = staticCompositionLocalOf { DodamTypography() }