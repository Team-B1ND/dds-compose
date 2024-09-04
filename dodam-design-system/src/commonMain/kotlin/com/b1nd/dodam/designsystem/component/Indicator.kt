package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

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
