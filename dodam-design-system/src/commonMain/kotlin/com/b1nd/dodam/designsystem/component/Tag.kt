package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme

@Composable
fun DodamTag(
    modifier: Modifier = Modifier,
    text: String,
    tagType: TagType
) {
    val colors = tagType.getColors()

    Box(
        modifier = modifier
            .background(
                color = colors.backgroundColor,
                shape = TagDefaults.DefaultShape
            )
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = 12.dp,
                    vertical = 2.dp
                ),
            text = text,
            color = colors.textColor,
            style = DodamTheme.typography.body1Bold().copy(fontWeight = FontWeight.Bold)
        )
    }

}


@Stable
enum class TagType {
    Primary,
    Secondary,
    Negative
}

@Immutable
data class TagColor(
    val backgroundColor: Color,
    val textColor: Color
)

@Composable
private fun TagType.getColors() =
    when (this) {
        TagType.Primary -> TagColor(TagDefaults.primaryBackground, TagDefaults.textColor)
        TagType.Secondary -> TagColor(TagDefaults.secondaryBackground, TagDefaults.textColor)
        TagType.Negative -> TagColor(TagDefaults.negativeBackground, TagDefaults.textColor)
    }


private object TagDefaults {
    val DefaultShape = CircleShape

    val primaryBackground @Composable get() = DodamTheme.colors.primaryNormal
    val secondaryBackground @Composable get() = DodamTheme.colors.lineNormal
    val negativeBackground @Composable get() = DodamTheme.colors.statusNegative

    val textColor @Composable get() = DodamTheme.colors.staticWhite
}