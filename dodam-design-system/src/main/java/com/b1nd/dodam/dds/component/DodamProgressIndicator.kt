package com.b1nd.dodam.dds.component

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.theme.DodamTheme

@Composable
fun DodamLinearProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.secondary,
    strokeCap: StrokeCap = StrokeCap.Round,
) {
    LinearProgressIndicator(
        progress = { progress },
        modifier = modifier
            .defaultMinSize(minHeight = 14.dp),
        color = color,
        trackColor = trackColor,
        strokeCap = strokeCap
    )
}

@Composable
fun DodamCircularProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    strokeWidth: Dp = 10.dp,
    trackColor: Color = MaterialTheme.colorScheme.secondary,
    strokeCap: StrokeCap = StrokeCap.Round,
) {
    CircularProgressIndicator(
        progress = { progress },
        modifier = modifier
            .defaultMinSize(minHeight = 70.dp, minWidth = 70.dp),
        color = color,
        strokeWidth = strokeWidth,
        trackColor = trackColor,
        strokeCap = strokeCap
    )
}

@Composable
@Preview
private fun DodamLinearProgressIndicatorPreview() {
    DodamTheme {
        DodamLinearProgressIndicator(
            progress = 0.2f,
        )
    }
}

@Composable
@Preview
private fun DodamCircularProgressIndicatorPreview() {
    DodamTheme {
        DodamCircularProgressIndicator(
            progress = 0.7f
        )
    }
}