package com.b1nd.dodam.designsystem.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme

@Composable
fun DodamDivider(
    modifier: Modifier = Modifier,
    type: DividerType = DividerType.Normal,
) {
    val thickness = when (type) {
        DividerType.Normal -> DividerDefaults.NormalThickness
        DividerType.Thick -> DividerDefaults.ThickThickness
    }

    val color = DividerDefaults.color

    Box(
        modifier
            .fillMaxWidth()
            .height(thickness)
            .background(color)
    )
}

@Composable
@Preview(showBackground = true, name = "Light Theme")
@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun DodamDividerPreview() {
    DodamTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            DodamDivider()

            DodamDivider(type = DividerType.Thick)
        }
    }
}

enum class DividerType {
    Normal,
    Thick,
}

object DividerDefaults {
    val NormalThickness: Dp = 1.dp
    val ThickThickness: Dp = 8.dp
    val color: Color @Composable get() = DodamTheme.colors.lineAlternative
}
