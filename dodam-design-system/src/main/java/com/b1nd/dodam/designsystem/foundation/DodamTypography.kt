package com.b1nd.dodam.designsystem.foundation

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.b1nd.dodam.designsystem.R
import com.b1nd.dodam.designsystem.tokens.TypefaceTokens
import com.b1nd.dodam.designsystem.tokens.TypographyTokens

@Immutable
data class DodamTypography(
    val display1: TextStyle = TypographyTokens.Display1,
    val display2: TextStyle = TypographyTokens.Display2,
    val title1: TextStyle = TypographyTokens.Title1,
    val title2: TextStyle = TypographyTokens.Title2,
    val title3: TextStyle = TypographyTokens.Title3,
    val heading1: TextStyle = TypographyTokens.Heading1,
    val heading2: TextStyle = TypographyTokens.Heading2,
    val headline1: TextStyle = TypographyTokens.Headline1,
    val headline2: TextStyle = TypographyTokens.Headline2,
    val body1: TextStyle = TypographyTokens.Body1,
    val body2: TextStyle = TypographyTokens.Body2,
    val label1: TextStyle = TypographyTokens.Label1,
    val label2: TextStyle = TypographyTokens.Label2,
    val caption1: TextStyle = TypographyTokens.Caption1,
    val caption2: TextStyle = TypographyTokens.Caption2
)

internal val LocalDodamTypography = staticCompositionLocalOf { DodamTypography() }