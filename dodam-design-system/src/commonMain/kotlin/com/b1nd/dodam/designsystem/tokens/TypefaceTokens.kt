package com.b1nd.dodam.designsystem.tokens

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.b1nd.dodam.designsystem.resources.Res
import com.b1nd.dodam.designsystem.resources.pretendard_bold
import com.b1nd.dodam.designsystem.resources.pretendard_extrabold
import com.b1nd.dodam.designsystem.resources.pretendard_medium
import com.b1nd.dodam.designsystem.resources.pretendard_regular
import com.b1nd.dodam.designsystem.resources.pretendard_semibold
import org.jetbrains.compose.resources.Font

internal object TypefaceTokens {
    val Pretendard @Composable get() = FontFamily(
        Font(Res.font.pretendard_extrabold, FontWeight.ExtraBold),
        Font(Res.font.pretendard_bold, FontWeight.Bold),
        Font(Res.font.pretendard_medium, FontWeight.Medium),
        Font(Res.font.pretendard_regular, FontWeight.Normal),
        Font(Res.font.pretendard_semibold, FontWeight.SemiBold)
    )
    val WeightExtraBold = FontWeight.ExtraBold
    val WeightBold = FontWeight.Bold
    val WeightMedium = FontWeight.Medium
    val WeightRegular = FontWeight.Normal
    val WeightSemiBold = FontWeight.SemiBold
}