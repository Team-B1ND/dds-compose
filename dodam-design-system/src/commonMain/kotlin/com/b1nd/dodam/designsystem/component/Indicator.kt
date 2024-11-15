package com.b1nd.dodam.designsystem.component

import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DodamPageIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    if (pagerState.pageCount > 1) {
        Row(modifier = modifier) {
            val lastIndex = pagerState.pageCount - 1
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) {
                        DodamTheme.colors.primaryNormal
                    } else {
                        DodamTheme.colors.labelDisabled
                    }

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color)
                        .size(5.dp),
                )
                if (lastIndex != iteration) {
                    Spacer(Modifier.width(5.dp))
                }
            }
        }
    }
}

@Composable
fun DodamLinerProgressIndicator(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) progress: Float,
    disabled: Boolean = false,
) {
    require(progress in 0f..1f) { "Progress must range from 0 to 1." }


    Row(
        modifier = modifier
            .height(LinerProgressIndicatorDefault.DefaultHeight)
            .background(
                color = DodamTheme.colors.lineAlternative,
                shape = LinerProgressIndicatorDefault.DefaultShape
            )
    ) {
        if (progress > 0f) {
            Box(
                modifier = Modifier
                    .weight(progress)
                    .background(
                        color = if (disabled) DodamTheme.colors.lineNormal
                        else DodamTheme.colors.primaryNormal,
                        shape = LinerProgressIndicatorDefault.DefaultShape
                    )
                    .fillMaxHeight()
            )
        }

        if (progress < 1f) {
            Spacer(Modifier.weight(1f - progress))
        }
    }
}

@Composable
fun DodamCircularProgressIndicator(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) progress: Float,
    disabled: Boolean = false,
) {
    require(progress in 0f..1f) { "Progress must range from 0 to 1." }

    val lineAlternative = DodamTheme.colors.lineAlternative
    val arcColor = if (disabled) DodamTheme.colors.lineNormal else DodamTheme.colors.primaryNormal
    Canvas(modifier = modifier) {
        drawCircle(
            color = lineAlternative,
            radius = size.minDimension / 2,
            style = Stroke(width = 10.dp.toPx())
        )

        drawArc(
            color = arcColor,
            startAngle = -90f,
            sweepAngle = 360f * progress,
            useCenter = false,
            style = Stroke(width = 10.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}


private object LinerProgressIndicatorDefault {
    val DefaultHeight = 14.dp

    val DefaultShape
        @ReadOnlyComposable
        @Composable
        get() = DodamTheme.shapes.extraSmall
}