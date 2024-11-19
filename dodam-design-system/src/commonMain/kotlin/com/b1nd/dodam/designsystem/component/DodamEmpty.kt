package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.foundation.DodamIcons

@Composable
fun DodamEmpty(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    imageVector: ImageVector = DodamIcons.FullMoonFace.value,
    contentDescription: String = "달이 웃는 표정",
    title: String,
    buttonText: String,
    border: BorderStroke? = null
) {
    Surface(
        modifier = modifier,
        color = DodamTheme.colors.backgroundNormal,
        shape = DodamTheme.shapes.large,
        border = border
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(36.dp),
                imageVector = imageVector,
                contentDescription = contentDescription
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = title,
                style = DodamTheme.typography.labelMedium(),
                color = DodamTheme.colors.labelAlternative.copy(alpha = 0.5f),
            )
            Spacer(modifier = Modifier.height(24.dp))
            DodamButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClick,
                text = buttonText,
                buttonSize = ButtonSize.Large,
                buttonRole = ButtonRole.Assistive
            )
        }
    }
}