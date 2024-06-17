package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.tokens.ColorDarkTokens
import com.b1nd.dodam.designsystem.tokens.ColorLightTokens
import com.b1nd.dodam.designsystem.tokens.DodamColorKeyTokens

@Immutable
data class DodamColors(
    val primaryNormal: Color,
    val primaryStrong: Color,
    val primaryHeavy: Color,
    val labelNormal: Color,
    val labelStrong: Color,
    val labelNeutral: Color,
    val labelAlternative: Color,
    val labelAssistive: Color,
    val labelDisable: Color,
    val backgroundNormalNormal: Color,
    val backgroundNormalAlternative: Color,
    val backgroundElevatedNormal: Color,
    val backgroundElevatedAlternative: Color,
    val interactionInactive: Color,
    val interactionDisable: Color,
    val lineNormalNormal: Color,
    val lineNormalNeutral: Color,
    val lineNormalAlternative: Color,
    val lineNormalStrong: Color,
    val lineSolidNormal: Color,
    val lineSolidNeutral: Color,
    val lineSolidAlternative: Color,
    val lineSolidStrong: Color,
    val statusPositive: Color,
    val statusNegative: Color,
    val statusCautionary: Color,
    val staticWhite: Color,
    val staticBlack: Color,
    val inversePrimary: Color,
    val inverseBackground: Color,
    val inverseLabel: Color,
    val componentFillNormal: Color,
    val componentFillStrong: Color,
    val componentFillAlternative: Color,
    val componentMaterialDimmer: Color
)

internal fun lightDodamColors(
    primaryNormal: Color = ColorLightTokens.Primary.Normal,
    primaryStrong: Color = ColorLightTokens.Primary.Strong,
    primaryHeavy: Color = ColorLightTokens.Primary.Heavy,
    labelNormal: Color = ColorLightTokens.Label.Normal,
    labelStrong: Color = ColorLightTokens.Label.Strong,
    labelNeutral: Color = ColorLightTokens.Label.Neutral,
    labelAlternative: Color = ColorLightTokens.Label.Alternative,
    labelAssistive: Color = ColorLightTokens.Label.Assistive,
    labelDisable: Color = ColorLightTokens.Label.Disable,
    backgroundNormalNormal: Color = ColorLightTokens.Background.Normal.Normal,
    backgroundNormalAlternative: Color = ColorLightTokens.Background.Normal.Alternative,
    backgroundElevatedNormal: Color = ColorLightTokens.Background.Elevated.Normal,
    backgroundElevatedAlternative: Color = ColorLightTokens.Background.Elevated.Alternative,
    interactionInactive: Color = ColorLightTokens.Interaction.Inactive,
    interactionDisable: Color = ColorLightTokens.Interaction.Disable,
    lineNormalNormal: Color = ColorLightTokens.Line.Normal.Normal,
    lineNormalNeutral: Color = ColorLightTokens.Line.Normal.Neutral,
    lineNormalAlternative: Color = ColorLightTokens.Line.Normal.Alternative,
    lineNormalStrong: Color = ColorLightTokens.Line.Normal.Strong,
    lineSolidNormal: Color = ColorLightTokens.Line.Solid.Normal,
    lineSolidNeutral: Color = ColorLightTokens.Line.Solid.Neutral,
    lineSolidAlternative: Color = ColorLightTokens.Line.Solid.Alternative,
    lineSolidStrong: Color = ColorLightTokens.Line.Solid.Strong,
    statusPositive: Color = ColorLightTokens.Status.Positive,
    statusNegative: Color = ColorLightTokens.Status.Negative,
    statusCautionary: Color = ColorLightTokens.Status.Cautionary,
    staticWhite: Color = ColorLightTokens.Static.White,
    staticBlack: Color = ColorLightTokens.Static.Black,
    inversePrimary: Color = ColorLightTokens.Inverse.Primary,
    inverseBackground: Color = ColorLightTokens.Inverse.Background,
    inverseLabel: Color = ColorLightTokens.Inverse.Label,
    componentFillNormal: Color = ColorLightTokens.Component.Fill.Normal,
    componentFillStrong: Color = ColorLightTokens.Component.Fill.Strong,
    componentFillAlternative: Color = ColorLightTokens.Component.Fill.Alternative,
    componentMaterialDimmer: Color = ColorLightTokens.Component.Material.Dimmer
): DodamColors = DodamColors(
    primaryNormal = primaryNormal,
    primaryStrong = primaryStrong,
    primaryHeavy = primaryHeavy,
    labelNormal = labelNormal,
    labelStrong = labelStrong,
    labelNeutral = labelNeutral,
    labelAlternative = labelAlternative,
    labelAssistive = labelAssistive,
    labelDisable = labelDisable,
    backgroundNormalNormal = backgroundNormalNormal,
    backgroundNormalAlternative = backgroundNormalAlternative,
    backgroundElevatedNormal = backgroundElevatedNormal,
    backgroundElevatedAlternative = backgroundElevatedAlternative,
    interactionInactive = interactionInactive,
    interactionDisable = interactionDisable,
    lineNormalNormal = lineNormalNormal,
    lineNormalNeutral = lineNormalNeutral,
    lineNormalAlternative = lineNormalAlternative,
    lineNormalStrong = lineNormalStrong,
    lineSolidNormal = lineSolidNormal,
    lineSolidNeutral = lineSolidNeutral,
    lineSolidAlternative = lineSolidAlternative,
    lineSolidStrong = lineSolidStrong,
    statusPositive = statusPositive,
    statusNegative = statusNegative,
    statusCautionary = statusCautionary,
    staticWhite = staticWhite,
    staticBlack = staticBlack,
    inversePrimary = inversePrimary,
    inverseBackground = inverseBackground,
    inverseLabel = inverseLabel,
    componentFillNormal = componentFillNormal,
    componentFillStrong = componentFillStrong,
    componentFillAlternative = componentFillAlternative,
    componentMaterialDimmer = componentMaterialDimmer
)

internal fun darkDodamColors(
    primaryNormal: Color = ColorDarkTokens.Primary.Normal,
    primaryStrong: Color = ColorDarkTokens.Primary.Strong,
    primaryHeavy: Color = ColorDarkTokens.Primary.Heavy,
    labelNormal: Color = ColorDarkTokens.Label.Normal,
    labelStrong: Color = ColorDarkTokens.Label.Strong,
    labelNeutral: Color = ColorDarkTokens.Label.Neutral,
    labelAlternative: Color = ColorDarkTokens.Label.Alternative,
    labelAssistive: Color = ColorDarkTokens.Label.Assistive,
    labelDisable: Color = ColorDarkTokens.Label.Disable,
    backgroundNormalNormal: Color = ColorDarkTokens.Background.Normal.Normal,
    backgroundNormalAlternative: Color = ColorDarkTokens.Background.Normal.Alternative,
    backgroundElevatedNormal: Color = ColorDarkTokens.Background.Elevated.Normal,
    backgroundElevatedAlternative: Color = ColorDarkTokens.Background.Elevated.Alternative,
    interactionInactive: Color = ColorDarkTokens.Interaction.Inactive,
    interactionDisable: Color = ColorDarkTokens.Interaction.Disable,
    lineNormalNormal: Color = ColorDarkTokens.Line.Normal.Normal,
    lineNormalNeutral: Color = ColorDarkTokens.Line.Normal.Neutral,
    lineNormalAlternative: Color = ColorDarkTokens.Line.Normal.Alternative,
    lineNormalStrong: Color = ColorDarkTokens.Line.Normal.Strong,
    lineSolidNormal: Color = ColorDarkTokens.Line.Solid.Normal,
    lineSolidNeutral: Color = ColorDarkTokens.Line.Solid.Neutral,
    lineSolidAlternative: Color = ColorDarkTokens.Line.Solid.Alternative,
    lineSolidStrong: Color = ColorDarkTokens.Line.Solid.Strong,
    statusPositive: Color = ColorDarkTokens.Status.Positive,
    statusNegative: Color = ColorDarkTokens.Status.Negative,
    statusCautionary: Color = ColorDarkTokens.Status.Cautionary,
    staticWhite: Color = ColorDarkTokens.Static.White,
    staticBlack: Color = ColorDarkTokens.Static.Black,
    inversePrimary: Color = ColorDarkTokens.Inverse.Primary,
    inverseBackground: Color = ColorDarkTokens.Inverse.Background,
    inverseLabel: Color = ColorDarkTokens.Inverse.Label,
    componentFillNormal: Color = ColorDarkTokens.Component.Fill.Normal,
    componentFillStrong: Color = ColorDarkTokens.Component.Fill.Strong,
    componentFillAlternative: Color = ColorDarkTokens.Component.Fill.Alternative,
    componentMaterialDimmer: Color = ColorDarkTokens.Component.Material.Dimmer
): DodamColors = DodamColors(
    primaryNormal = primaryNormal,
    primaryStrong = primaryStrong,
    primaryHeavy = primaryHeavy,
    labelNormal = labelNormal,
    labelStrong = labelStrong,
    labelNeutral = labelNeutral,
    labelAlternative = labelAlternative,
    labelAssistive = labelAssistive,
    labelDisable = labelDisable,
    backgroundNormalNormal = backgroundNormalNormal,
    backgroundNormalAlternative = backgroundNormalAlternative,
    backgroundElevatedNormal = backgroundElevatedNormal,
    backgroundElevatedAlternative = backgroundElevatedAlternative,
    interactionInactive = interactionInactive,
    interactionDisable = interactionDisable,
    lineNormalNormal = lineNormalNormal,
    lineNormalNeutral = lineNormalNeutral,
    lineNormalAlternative = lineNormalAlternative,
    lineNormalStrong = lineNormalStrong,
    lineSolidNormal = lineSolidNormal,
    lineSolidNeutral = lineSolidNeutral,
    lineSolidAlternative = lineSolidAlternative,
    lineSolidStrong = lineSolidStrong,
    statusPositive = statusPositive,
    statusNegative = statusNegative,
    statusCautionary = statusCautionary,
    staticWhite = staticWhite,
    staticBlack = staticBlack,
    inversePrimary = inversePrimary,
    inverseBackground = inverseBackground,
    inverseLabel = inverseLabel,
    componentFillNormal = componentFillNormal,
    componentFillStrong = componentFillStrong,
    componentFillAlternative = componentFillAlternative,
    componentMaterialDimmer = componentMaterialDimmer
)

@Stable
internal fun DodamColors.fromToken(value: DodamColorKeyTokens): Color {
    return when (value) {
        DodamColorKeyTokens.PrimaryNormal -> primaryNormal
        DodamColorKeyTokens.PrimaryStrong -> primaryStrong
        DodamColorKeyTokens.PrimaryHeavy -> primaryHeavy
        DodamColorKeyTokens.LabelNormal -> labelNormal
        DodamColorKeyTokens.LabelStrong -> labelStrong
        DodamColorKeyTokens.LabelNeutral -> labelNeutral
        DodamColorKeyTokens.LabelAlternative -> labelAlternative
        DodamColorKeyTokens.LabelAssistive -> labelAssistive
        DodamColorKeyTokens.LabelDisable -> labelDisable
        DodamColorKeyTokens.BackgroundNormalNormal -> backgroundNormalNormal
        DodamColorKeyTokens.BackgroundNormalAlternative -> backgroundNormalAlternative
        DodamColorKeyTokens.BackgroundElevatedNormal -> backgroundElevatedNormal
        DodamColorKeyTokens.BackgroundElevatedAlternative -> backgroundElevatedAlternative
        DodamColorKeyTokens.InteractionInactive -> interactionInactive
        DodamColorKeyTokens.InteractionDisable -> interactionDisable
        DodamColorKeyTokens.LineNormalNormal -> lineNormalNormal
        DodamColorKeyTokens.LineNormalNeutral -> lineNormalNeutral
        DodamColorKeyTokens.LineNormalAlternative -> lineNormalAlternative
        DodamColorKeyTokens.LineNormalStrong -> lineNormalStrong
        DodamColorKeyTokens.LineSolidNormal -> lineSolidNormal
        DodamColorKeyTokens.LineSolidNeutral -> lineSolidNeutral
        DodamColorKeyTokens.LineSolidAlternative -> lineSolidAlternative
        DodamColorKeyTokens.LineSolidStrong -> lineSolidStrong
        DodamColorKeyTokens.StatusPositive -> statusPositive
        DodamColorKeyTokens.StatusNegative -> statusNegative
        DodamColorKeyTokens.StatusCautionary -> statusCautionary
        DodamColorKeyTokens.StaticWhite -> staticWhite
        DodamColorKeyTokens.StaticBlack -> staticBlack
    }
}

internal val LocalDodamColors = staticCompositionLocalOf { lightDodamColors() }

internal val DodamColorKeyTokens.value: Color
    @ReadOnlyComposable
    @Composable
    get() = DodamTheme.colors.fromToken(this)

