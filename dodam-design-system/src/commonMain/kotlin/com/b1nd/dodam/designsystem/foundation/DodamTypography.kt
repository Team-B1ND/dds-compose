package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import com.b1nd.dodam.designsystem.tokens.TypographyTokens

@Immutable
data class DodamTypography(
    val title1Bold: @Composable () -> TextStyle = { TypographyTokens.Title1.Bold },
    val title1Medium: @Composable () -> TextStyle = { TypographyTokens.Title1.Medium },
    val title1Regular: @Composable () -> TextStyle = { TypographyTokens.Title1.Regular },
    val title2Bold: @Composable () -> TextStyle = { TypographyTokens.Title2.Bold },
    val title2Medium: @Composable () -> TextStyle = { TypographyTokens.Title2.Medium },
    val title2Regular: @Composable () -> TextStyle = { TypographyTokens.Title2.Regular },
    val title3Bold: @Composable () -> TextStyle = { TypographyTokens.Title3.Bold },
    val title3Medium: @Composable () -> TextStyle = { TypographyTokens.Title3.Medium },
    val title3Regular: @Composable () -> TextStyle = { TypographyTokens.Title3.Regular },
    val headlineBold: @Composable () -> TextStyle = { TypographyTokens.Headline.Bold },
    val headlineMedium: @Composable () -> TextStyle = { TypographyTokens.Headline.Medium },
    val headlineRegular: @Composable () -> TextStyle = { TypographyTokens.Headline.Regular },
    val heading1Bold: @Composable () -> TextStyle = { TypographyTokens.Heading1.Bold },
    val heading1Medium: @Composable () -> TextStyle = { TypographyTokens.Heading1.Medium },
    val heading1Regular: @Composable () -> TextStyle = { TypographyTokens.Heading1.Regular },
    val heading2Bold: @Composable () -> TextStyle = { TypographyTokens.Heading2.Bold },
    val heading2Medium: @Composable () -> TextStyle = { TypographyTokens.Heading2.Medium },
    val heading2Regular: @Composable () -> TextStyle = { TypographyTokens.Heading2.Regular },
    val body1Bold: @Composable () -> TextStyle = { TypographyTokens.Body1.Bold },
    val body1Medium: @Composable () -> TextStyle = { TypographyTokens.Body1.Medium },
    val body1Regular: @Composable () -> TextStyle = { TypographyTokens.Body1.Regular },
    val body2Bold: @Composable () -> TextStyle = { TypographyTokens.Body2.Bold },
    val body2Medium: @Composable () -> TextStyle = { TypographyTokens.Body2.Medium },
    val body2Regular: @Composable () -> TextStyle = { TypographyTokens.Body2.Regular },
    val labelBold: @Composable () -> TextStyle = { TypographyTokens.Label.Bold },
    val labelMedium: @Composable () -> TextStyle = { TypographyTokens.Label.Medium },
    val labelRegular: @Composable () -> TextStyle = { TypographyTokens.Label.Regular },
    val caption1Bold: @Composable () -> TextStyle = { TypographyTokens.Caption1.Bold },
    val caption1Medium: @Composable () -> TextStyle = { TypographyTokens.Caption1.Medium },
    val caption1Regular: @Composable () -> TextStyle = { TypographyTokens.Caption1.Regular },
    val caption2Bold: @Composable () -> TextStyle = { TypographyTokens.Caption2.Bold },
    val caption2Medium: @Composable () -> TextStyle = { TypographyTokens.Caption2.Medium },
    val caption2Regular: @Composable () -> TextStyle = { TypographyTokens.Caption2.Regular }
)

internal val LocalDodamTypography = staticCompositionLocalOf { DodamTypography() }