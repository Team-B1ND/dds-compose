package com.b1nd.dodam.designsystem.tokens

internal object ColorDarkTokens {
    object Primary {
        val Normal = PaletteTokens.Blue45
        val Assistive = PaletteTokens.Blue45.copy(alpha = 0.3f)
    }

    object Label {
        val Normal = PaletteTokens.Neutral99
        val Strong = PaletteTokens.White
        val Neutral = PaletteTokens.Neutral95
        val Alternative = PaletteTokens.Neutral90
        val Assistive = PaletteTokens.Neutral70
        val Disabled = PaletteTokens.Neutral30
    }

    object Background {
        val Normal = PaletteTokens.Neutral15
        val Alternative = PaletteTokens.Neutral5
        val Neutral = PaletteTokens.Neutral99
    }

    object Line {
        val Normal = PaletteTokens.Neutral50
        val Neutral = PaletteTokens.Neutral30
        val Alternative = PaletteTokens.Neutral25
    }

    object Fill {
        val Normal = PaletteTokens.Neutral20
        val Neutral = PaletteTokens.Neutral25
        val Alternative = PaletteTokens.Neutral30
        val Assistive = PaletteTokens.Neutral60
    }

    object Status {
        val Positive = PaletteTokens.Green60
        val Negative = PaletteTokens.Red50
        val Cautionary = PaletteTokens.Yellow60
    }

    object Static {
        val White = PaletteTokens.White
        val Black = PaletteTokens.Black
    }
}
