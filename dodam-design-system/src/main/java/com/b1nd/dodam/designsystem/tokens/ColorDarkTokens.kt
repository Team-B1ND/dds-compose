package com.b1nd.dodam.designsystem.tokens

internal object ColorDarkTokens {
    object Primary {
        val Normal = PaletteTokens.Blue60
        val Strong = PaletteTokens.Blue55
        val Heavy = PaletteTokens.Blue50
    }

    object Label {
        val Normal = PaletteTokens.Neutral99
        val Strong = PaletteTokens.White
        val Neutral = PaletteTokens.Neutral90.copy(PaletteTokens.OPACITY_88)
        val Alternative = PaletteTokens.Neutral80.copy(PaletteTokens.OPACITY_61)
        val Assistive = PaletteTokens.Neutral80.copy(PaletteTokens.OPACITY_28)
        val Disable = PaletteTokens.Neutral70.copy(PaletteTokens.OPACITY_16)
    }

    object Background {
        object Normal {
            val Normal = PaletteTokens.Neutral15
            val Alternative = PaletteTokens.Neutral5
        }

        object Elevated {
            val Normal = PaletteTokens.Neutral17
            val Alternative = PaletteTokens.Neutral17
        }
    }

    object Interaction {
        val Inactive = PaletteTokens.Neutral40
        val Disable = PaletteTokens.Neutral22
    }

    object Line {
        object Normal {
            val Normal = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_35)
            val Neutral = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_28)
            val Alternative = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_22)
            val Strong = PaletteTokens.Neutral90.copy(PaletteTokens.OPACITY_52)
        }

        object Solid {
            val Normal = PaletteTokens.Neutral25
            val Neutral = PaletteTokens.Neutral23
            val Alternative = PaletteTokens.Neutral22
            val Strong = PaletteTokens.Neutral50
        }
    }

    object Status {
        val Positive = PaletteTokens.Green60
        val Negative = PaletteTokens.Red60
        val Cautionary = PaletteTokens.Yellow60
    }

    object Static {
        val White = PaletteTokens.White
        val Black = PaletteTokens.Black
    }

    object Inverse {
        val Primary = PaletteTokens.Blue50
        val Background = PaletteTokens.White
        val Label = PaletteTokens.Neutral10
    }

    object Component {
        object Fill {
            val Normal = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_22)
            val Strong = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_28)
            val Alternative = PaletteTokens.Neutral50.copy(PaletteTokens.OPACITY_12)
        }

        object Material {
            val Dimmer = PaletteTokens.Neutral10.copy(PaletteTokens.OPACITY_74)
        }
    }
}
