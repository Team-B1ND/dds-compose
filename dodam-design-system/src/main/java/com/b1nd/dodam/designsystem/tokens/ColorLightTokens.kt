package com.b1nd.dodam.designsystem.tokens

internal object ColorLightTokens {
    object Primary {
        val Normal = PaletteTokens.Blue500
        val Assistive = PaletteTokens.Blue100
    }

    object Label {
        val Normal = PaletteTokens.Gray900
        val Strong = PaletteTokens.Black
        val Neutral = PaletteTokens.Gray600
        val Alternative = PaletteTokens.Gray500
        val Assistive = PaletteTokens.Gray450
        val Disabled = PaletteTokens.Gray100
    }

    object Background {
        val Normal = PaletteTokens.White
        val Alternative = PaletteTokens.Gray150
    }

    object Line {
        val Normal = PaletteTokens.Gray300
        val Neutral = PaletteTokens.Gray250
        val Alternative = PaletteTokens.Gray150
    }

    object Status {
        val Positive = PaletteTokens.Green500
        val Negative = PaletteTokens.Red500
        val Cautionary = PaletteTokens.Yellow500
    }

    object Static {
        val White = PaletteTokens.White
        val Black = PaletteTokens.Black
    }

    object Component {
        val Normal = PaletteTokens.Gray150
        val Strong = PaletteTokens.Gray200
    }
}
