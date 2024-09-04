package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme

@Composable
fun DodamBadge(
    modifier: Modifier = Modifier,
    count: String? = null,
) {
    if (count == null) {
        Box(
            modifier = modifier
                .size(8.dp)
                .background(
                    color = DodamTheme.colors.statusNegative,
                    shape = CircleShape
                )
        )
    } else {
        Box(
            modifier = modifier
                .background(
                    color = DodamTheme.colors.statusNegative,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 6.dp),
                text = count,
                style = DodamTheme.typography.labelMedium(),
                color = DodamTheme.colors.staticWhite
            )
        }
    }
}