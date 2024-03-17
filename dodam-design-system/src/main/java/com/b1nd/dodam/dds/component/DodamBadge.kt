package com.b1nd.dodam.dds.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.style.BodySmall
import com.b1nd.dodam.dds.theme.DodamTheme

@Composable
fun DodamBadge(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.error,
    contentColor: Color = MaterialTheme.colorScheme.onError,
    content: @Composable (RowScope.() -> Unit)? = null,
) {
    Badge(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        content = content,
    )
}

@Composable
@Preview
private fun DodamBadgePreview() {
    DodamTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DodamBadge()
            DodamBadge {
                BodySmall(text = "1")
            }
            DodamBadge {
                BodySmall(text = "999+")
            }
        }
    }
}