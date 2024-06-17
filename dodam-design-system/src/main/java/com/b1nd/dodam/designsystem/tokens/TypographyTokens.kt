package com.b1nd.dodam.designsystem.tokens

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle

internal object TypographyTokens {
    val Display1 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Display1Font,
        fontWeight = TypeScaleTokens.Display1Weight,
        fontSize = TypeScaleTokens.Display1Size,
        lineHeight = TypeScaleTokens.Display1LineHeight,
        letterSpacing = TypeScaleTokens.Display1Tracking
    )
    val Display2 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Display2Font,
        fontWeight = TypeScaleTokens.Display2Weight,
        fontSize = TypeScaleTokens.Display2Size,
        lineHeight = TypeScaleTokens.Display2LineHeight,
        letterSpacing = TypeScaleTokens.Display2Tracking
    )
    val Title1 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Title1Font,
        fontWeight = TypeScaleTokens.Title1Weight,
        fontSize = TypeScaleTokens.Title1Size,
        lineHeight = TypeScaleTokens.Title1LineHeight,
        letterSpacing = TypeScaleTokens.Title1Tracking
    )
    val Title2 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Title2Font,
        fontWeight = TypeScaleTokens.Title2Weight,
        fontSize = TypeScaleTokens.Title2Size,
        lineHeight = TypeScaleTokens.Title2LineHeight,
        letterSpacing = TypeScaleTokens.Title2Tracking
    )
    val Title3 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Title3Font,
        fontWeight = TypeScaleTokens.Title3Weight,
        fontSize = TypeScaleTokens.Title3Size,
        lineHeight = TypeScaleTokens.Title3LineHeight,
        letterSpacing = TypeScaleTokens.Title3Tracking
    )
    val Heading1 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Heading1Font,
        fontWeight = TypeScaleTokens.Heading1Weight,
        fontSize = TypeScaleTokens.Heading1Size,
        lineHeight = TypeScaleTokens.Heading1LineHeight,
        letterSpacing = TypeScaleTokens.Heading1Tracking
    )
    val Heading2 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Heading2Font,
        fontWeight = TypeScaleTokens.Heading2Weight,
        fontSize = TypeScaleTokens.Heading2Size,
        lineHeight = TypeScaleTokens.Heading2LineHeight,
        letterSpacing = TypeScaleTokens.Heading2Tracking
    )
    val Headline1 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Headline1Font,
        fontWeight = TypeScaleTokens.Headline1Weight,
        fontSize = TypeScaleTokens.Headline1Size,
        lineHeight = TypeScaleTokens.Headline1LineHeight,
        letterSpacing = TypeScaleTokens.Headline1Tracking
    )
    val Headline2 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Headline2Font,
        fontWeight = TypeScaleTokens.Headline2Weight,
        fontSize = TypeScaleTokens.Headline2Size,
        lineHeight = TypeScaleTokens.Headline2LineHeight,
        letterSpacing = TypeScaleTokens.Headline2Tracking
    )
    val Body1 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Body1Font,
        fontWeight = TypeScaleTokens.Body1Weight,
        fontSize = TypeScaleTokens.Body1Size,
        lineHeight = TypeScaleTokens.Body1LineHeight,
        letterSpacing = TypeScaleTokens.Body1Tracking
    )
    val Body2 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Body2Font,
        fontWeight = TypeScaleTokens.Body2Weight,
        fontSize = TypeScaleTokens.Body2Size,
        lineHeight = TypeScaleTokens.Body2LineHeight,
        letterSpacing = TypeScaleTokens.Body2Tracking
    )
    val Label1 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Label1Font,
        fontWeight = TypeScaleTokens.Label1Weight,
        fontSize = TypeScaleTokens.Label1Size,
        lineHeight = TypeScaleTokens.Label1LineHeight,
        letterSpacing = TypeScaleTokens.Label1Tracking
    )
    val Label2 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Label2Font,
        fontWeight = TypeScaleTokens.Label2Weight,
        fontSize = TypeScaleTokens.Label2Size,
        lineHeight = TypeScaleTokens.Label2LineHeight,
        letterSpacing = TypeScaleTokens.Label2Tracking
    )
    val Caption1 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Caption1Font,
        fontWeight = TypeScaleTokens.Caption1Weight,
        fontSize = TypeScaleTokens.Caption1Size,
        lineHeight = TypeScaleTokens.Caption1LineHeight,
        letterSpacing = TypeScaleTokens.Caption1Tracking
    )
    val Caption2 = DefaultTextStyle.copy(
        fontFamily = TypeScaleTokens.Caption2Font,
        fontWeight = TypeScaleTokens.Caption2Weight,
        fontSize = TypeScaleTokens.Caption2Size,
        lineHeight = TypeScaleTokens.Caption2LineHeight,
        letterSpacing = TypeScaleTokens.Caption2Tracking
    )
}


private const val DefaultIncludeFontPadding = false

internal val DefaultLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

internal val DefaultTextStyle = TextStyle.Default.copy(
    platformStyle = PlatformTextStyle(
        includeFontPadding = DefaultIncludeFontPadding
    ),
    lineHeightStyle = DefaultLineHeightStyle,
)
