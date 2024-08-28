package com.b1nd.dodam.designsystem.tokens

internal object ColorLightTokens {
    object Primary {
        val Normal = PaletteTokens.Blue45
        val Assistive = PaletteTokens.Blue45.copy(alpha = 0.3f)
    }

    object Label {
        val Normal = PaletteTokens.Neutral5
        val Strong = PaletteTokens.Black
        val Neutral = PaletteTokens.Neutral25
        val Alternative = PaletteTokens.Neutral40
        val Assistive = PaletteTokens.Neutral50
        val Disabled = PaletteTokens.Neutral97
    }

    object Background {
        val Normal = PaletteTokens.White
        val Alternative = PaletteTokens.Neutral99
        val Neutral = PaletteTokens.Neutral99
    }

    object Line {
        val Normal = PaletteTokens.Neutral90
        val Neutral = PaletteTokens.Neutral95
        val Alternative = PaletteTokens.Neutral97
    }

    object Fill {
        val Normal = PaletteTokens.Neutral99
        val Neutral = PaletteTokens.Neutral97
        val Alternative = PaletteTokens.Neutral95
        val Assistive = PaletteTokens.White
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
}
