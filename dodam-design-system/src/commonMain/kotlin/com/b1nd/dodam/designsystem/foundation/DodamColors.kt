package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.b1nd.dodam.designsystem.tokens.ColorDarkTokens
import com.b1nd.dodam.designsystem.tokens.ColorLightTokens

@Immutable
data class DodamColors(
    val primaryNormal: Color,
    val primaryAssistive: Color,
    val labelNormal: Color,
    val labelStrong: Color,
    val labelNeutral: Color,
    val labelAlternative: Color,
    val labelAssistive: Color,
    val labelDisabled: Color,
    val backgroundNormal: Color,
    val backgroundAlternative: Color,
    val lineNormal: Color,
    val lineNeutral: Color,
    val lineAlternative: Color,
    val fillNormal: Color,
    val fillNeutral: Color,
    val fillAlternative: Color,
    val fillAssistive: Color,
    val statusPositive: Color,
    val statusNegative: Color,
    val statusCautionary: Color,
    val staticWhite: Color,
    val staticBlack: Color,
)

internal fun lightDodamColors(
    primaryNormal: Color = ColorLightTokens.Primary.Normal,
    primaryDisabled: Color = ColorLightTokens.Primary.Assistive,
    labelNormal: Color = ColorLightTokens.Label.Normal,
    labelStrong: Color = ColorLightTokens.Label.Strong,
    labelNeutral: Color = ColorLightTokens.Label.Neutral,
    labelAlternative: Color = ColorLightTokens.Label.Alternative,
    labelAssistive: Color = ColorLightTokens.Label.Assistive,
    labelDisabled: Color = ColorLightTokens.Label.Disabled,
    backgroundNormal: Color = ColorLightTokens.Background.Normal,
    backgroundAlternative: Color = ColorLightTokens.Background.Alternative,
    lineNormal: Color = ColorLightTokens.Line.Normal,
    lineNeutral: Color = ColorLightTokens.Line.Neutral,
    lineAlternative: Color = ColorLightTokens.Line.Alternative,
    fillNormal: Color = ColorLightTokens.Fill.Normal,
    fillNeutral: Color = ColorLightTokens.Fill.Neutral,
    fillAlternative: Color = ColorLightTokens.Fill.Alternative,
    fillAssistive: Color = ColorLightTokens.Fill.Assistive,
    statusPositive: Color = ColorLightTokens.Status.Positive,
    statusNegative: Color = ColorLightTokens.Status.Negative,
    statusCautionary: Color = ColorLightTokens.Status.Cautionary,
    staticWhite: Color = ColorLightTokens.Static.White,
    staticBlack: Color = ColorLightTokens.Static.Black,
): DodamColors = DodamColors(
    primaryNormal = primaryNormal,
    primaryAssistive = primaryDisabled,
    labelNormal = labelNormal,
    labelStrong = labelStrong,
    labelNeutral = labelNeutral,
    labelAlternative = labelAlternative,
    labelAssistive = labelAssistive,
    labelDisabled = labelDisabled,
    backgroundNormal = backgroundNormal,
    backgroundAlternative = backgroundAlternative,
    lineNormal = lineNormal,
    lineNeutral = lineNeutral,
    lineAlternative = lineAlternative,
    fillNormal = fillNormal,
    fillNeutral = fillNeutral,
    fillAlternative = fillAlternative,
    fillAssistive = fillAssistive,
    statusPositive = statusPositive,
    statusNegative = statusNegative,
    statusCautionary = statusCautionary,
    staticWhite = staticWhite,
    staticBlack = staticBlack,
)

internal fun darkDodamColors(
    primaryNormal: Color = ColorDarkTokens.Primary.Normal,
    primaryDisabled: Color = ColorDarkTokens.Primary.Assistive,
    labelNormal: Color = ColorDarkTokens.Label.Normal,
    labelStrong: Color = ColorDarkTokens.Label.Strong,
    labelNeutral: Color = ColorDarkTokens.Label.Neutral,
    labelAlternative: Color = ColorDarkTokens.Label.Alternative,
    labelAssistive: Color = ColorDarkTokens.Label.Assistive,
    labelDisabled: Color = ColorDarkTokens.Label.Disabled,
    backgroundNormal: Color = ColorDarkTokens.Background.Normal,
    backgroundAlternative: Color = ColorDarkTokens.Background.Alternative,
    lineNormal: Color = ColorDarkTokens.Line.Normal,
    lineNeutral: Color = ColorDarkTokens.Line.Neutral,
    lineAlternative: Color = ColorDarkTokens.Line.Alternative,
    fillNormal: Color = ColorDarkTokens.Fill.Normal,
    fillNeutral: Color = ColorDarkTokens.Fill.Neutral,
    fillAlternative: Color = ColorDarkTokens.Fill.Alternative,
    fillAssistive: Color = ColorDarkTokens.Fill.Assistive,
    statusPositive: Color = ColorDarkTokens.Status.Positive,
    statusNegative: Color = ColorDarkTokens.Status.Negative,
    statusCautionary: Color = ColorDarkTokens.Status.Cautionary,
    staticWhite: Color = ColorDarkTokens.Static.White,
    staticBlack: Color = ColorDarkTokens.Static.Black,
): DodamColors = DodamColors(
    primaryNormal = primaryNormal,
    primaryAssistive = primaryDisabled,
    labelNormal = labelNormal,
    labelStrong = labelStrong,
    labelNeutral = labelNeutral,
    labelAlternative = labelAlternative,
    labelAssistive = labelAssistive,
    labelDisabled = labelDisabled,
    backgroundNormal = backgroundNormal,
    backgroundAlternative = backgroundAlternative,
    lineNormal = lineNormal,
    lineNeutral = lineNeutral,
    lineAlternative = lineAlternative,
    fillNormal = fillNormal,
    fillNeutral = fillNeutral,
    fillAlternative = fillAlternative,
    fillAssistive = fillAssistive,
    statusPositive = statusPositive,
    statusNegative = statusNegative,
    statusCautionary = statusCautionary,
    staticWhite = staticWhite,
    staticBlack = staticBlack,
)

internal val LocalDodamColors = staticCompositionLocalOf { lightDodamColors() }
