package com.b1nd.dodam.designsystem.tokens

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

internal object TypographyTokens {
    val Headline1 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightBold,
        fontSize = 28.sp,
        lineHeight = 1.3.em,
    )
    val Headline2 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightBold,
        fontSize = 24.sp,
        lineHeight = 1.3.em,
    )
    val Headline3 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightBold,
        fontSize = 18.sp,
        lineHeight = 1.3.em,
    )
    val Title1 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightBold,
        fontSize = 20.sp,
        lineHeight = 1.3.em,
    )
    val Title2 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightSemiBold,
        fontSize = 18.sp,
        lineHeight = 1.3.em,
    )
    val Title3 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightSemiBold,
        fontSize = 16.sp,
        lineHeight = 1.3.em,
    )
    val Body1Strong = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightSemiBold,
        fontSize = 16.sp,
        lineHeight = 1.3.em,
    )
    val Body1Normal = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightMedium,
        fontSize = 16.sp,
        lineHeight = 1.3.em,
    )
    val Body2Strong = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightSemiBold,
        fontSize = 15.sp,
        lineHeight = 1.3.em,
    )
    val Body2Normal = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightMedium,
        fontSize = 15.sp,
        lineHeight = 1.3.em,
    )
    val Body3Strong = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightSemiBold,
        fontSize = 13.sp,
        lineHeight = 1.3.em,
    )
    val Body3Normal = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightMedium,
        fontSize = 13.sp,
        lineHeight = 1.3.em,
    )
    val Label1 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightRegular,
        fontSize = 13.sp,
        lineHeight = 1.3.em,
    )
    val Label2 = DefaultTextStyle.copy(
        fontFamily = TypefaceTokens.Pretendard,
        fontWeight = TypefaceTokens.WeightRegular,
        fontSize = 12.sp,
        lineHeight = 1.3.em,
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
