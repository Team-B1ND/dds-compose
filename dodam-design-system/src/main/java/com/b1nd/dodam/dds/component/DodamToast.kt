package com.b1nd.dodam.dds.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.foundation.DodamColor
import com.b1nd.dodam.dds.style.CheckmarkCircleFilledIcon
import com.b1nd.dodam.dds.style.CheckmarkCircleIcon
import com.b1nd.dodam.dds.style.LabelLarge
import com.b1nd.dodam.dds.theme.DodamTheme

@Composable
fun DodamToast(
    text: String,
    textColor: Color = DodamColor.White,
    trailingIcon: @Composable () -> Unit,
    iconColor: Color = DodamColor.Green,
    containerColor: Color = if (isSystemInDarkTheme()) DodamColor.Gray750 else DodamColor.Gray500,
) {
    Row(
        modifier = Modifier
            .background(containerColor, CircleShape)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CompositionLocalProvider(
            LocalContentColor provides iconColor,
            content = trailingIcon
        )
        LabelLarge(text = text, fontWeight = FontWeight.SemiBold, color = textColor)
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun DodamToastPreview() {
    DodamTheme {
        DodamToast(
            text = "외출 신청을 성공했어요",
            trailingIcon = { CheckmarkCircleFilledIcon(
                modifier = Modifier
                    .size(20.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = DodamColor.White,
                            topLeft = Offset(12f, 12f),
                            size = Size(30f, 30f)
                        )
                    }
            ) }
        )
    }
}