package com.b1nd.dodam.designsystem.tokens

internal object ColorLightTokens {
    object Primary {
        val Normal = PaletteTokens.Blue50
        val Strong = PaletteTokens.Blue45
        val Heavy = PaletteTokens.Blue40
    }

    object Label {
        val Normal = PaletteTokens.Neutral10
        val Strong = PaletteTokens.Black
        val Neutral = PaletteTokens.Neutral10.copy(PaletteTokens.OPACITY_88)
        val Alternative = PaletteTokens.Neutral10.copy(PaletteTokens.OPACITY_61)
        val Assistive = PaletteTokens.Neutral10.copy(PaletteTokens.OPACITY_28)
        val Disable = PaletteTokens.Neutral10.copy(PaletteTokens.OPACITY_16)
    }

    object Background {
        object Normal {
            val Normal = PaletteTokens.White
            val Alternative = PaletteTokens.Neutral99
        }

        object Elevated {
            val Normal = PaletteTokens.White
            val Alternative = PaletteTokens.Neutral99
        }
    }

    object Interaction {
        val Inactive = PaletteTokens.Neutral70
        val Disable = PaletteTokens.Neutral98
    }

    object Line {
        object Normal {
            val Normal = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_22)
            val Neutral = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_16)
            val Alternative = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_8)
            val Strong = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_52)
        }

        object Solid {
            val Normal = PaletteTokens.Neutral96
            val Neutral = PaletteTokens.Neutral97
            val Alternative = PaletteTokens.Neutral98
            val Strong = PaletteTokens.Neutral80
        }
    }

    object Status {
        val Positive = PaletteTokens.Green50
        val Negative = PaletteTokens.Red50
        val Cautionary = PaletteTokens.Yellow50
    }

    object Static {
        val White = PaletteTokens.White
        val Black = PaletteTokens.Black
    }

    object Inverse {
        val Primary = PaletteTokens.Blue60
        val Background = PaletteTokens.Neutral15
        val Label = PaletteTokens.Neutral99
    }

    object Component {
        object Fill {
            val Normal = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_8)
            val Strong = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_16)
            val Alternative = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_5)
        }

        object Material {
            val Dimmer = PaletteTokens.Neutral10.copy(PaletteTokens.OPACITY_52)
        }
    }
}
