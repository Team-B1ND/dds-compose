package com.b1nd.dodam.designsystem.tokens

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

internal object TypographyTokens {
    object Title1 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightExtraBold,
            fontSize = 36.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 36.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 36.sp,
            lineHeight = 1.3.em,
        )
    }
    object Title2 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightExtraBold,
            fontSize = 28.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 28.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 28.sp,
            lineHeight = 1.3.em,
        )
    }
    object Title3 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightExtraBold,
            fontSize = 24.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 24.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 24.sp,
            lineHeight = 1.3.em,
        )
    }
    object Heading1 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightExtraBold,
            fontSize = 22.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 22.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 22.sp,
            lineHeight = 1.3.em,
        )
    }
    object Heading2 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightExtraBold,
            fontSize = 20.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 20.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 20.sp,
            lineHeight = 1.3.em,
        )
    }
    object Headline {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightBold,
            fontSize = 18.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 18.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 18.sp,
            lineHeight = 1.3.em,
        )
    }
    object Body1 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightSemiBold,
            fontSize = 16.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 16.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 16.sp,
            lineHeight = 1.3.em,
        )
    }
    object Body2 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightSemiBold,
            fontSize = 15.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 15.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 15.sp,
            lineHeight = 1.3.em,
        )
    }
    object Label {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightSemiBold,
            fontSize = 14.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 14.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 14.sp,
            lineHeight = 1.3.em,
        )
    }
    object Caption1 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightSemiBold,
            fontSize = 13.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 13.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 13.sp,
            lineHeight = 1.3.em,
        )
    }
    object Caption2 {
        val Bold @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightSemiBold,
            fontSize = 12.sp,
            lineHeight = 1.3.em,
        )
        val Medium @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightMedium,
            fontSize = 12.sp,
            lineHeight = 1.3.em,
        )
        val Regular @Composable get() = DefaultTextStyle.copy(
            fontFamily = TypefaceTokens.Pretendard,
            fontWeight = TypefaceTokens.WeightRegular,
            fontSize = 12.sp,
            lineHeight = 1.3.em,
        )
    }
}


internal val DefaultLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

internal val DefaultTextStyle = TextStyle.Default.copy(
    lineHeightStyle = DefaultLineHeightStyle,
)
