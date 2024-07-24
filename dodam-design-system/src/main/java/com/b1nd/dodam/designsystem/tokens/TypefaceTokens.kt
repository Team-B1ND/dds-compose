package com.b1nd.dodam.designsystem.tokens

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.b1nd.dodam.designsystem.R

internal object TypefaceTokens {
    val Pretendard = FontFamily(
        Font(R.font.pretendard_extrabold, FontWeight.ExtraBold),
        Font(R.font.pretendard_bold, FontWeight.Bold),
        Font(R.font.pretendard_medium, FontWeight.Medium),
        Font(R.font.pretendard_regular, FontWeight.Normal),
        Font(R.font.pretendard_semibold, FontWeight.SemiBold)
    )
    val WeightExtraBold = FontWeight.ExtraBold
    val WeightBold = FontWeight.Bold
    val WeightMedium = FontWeight.Medium
    val WeightRegular = FontWeight.Normal
    val WeightSemiBold = FontWeight.SemiBold
}