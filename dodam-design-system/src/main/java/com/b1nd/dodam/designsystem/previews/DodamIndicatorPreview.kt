package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamCircularProgressIndicator
import com.b1nd.dodam.designsystem.component.DodamLinerProgressIndicator
import com.b1nd.dodam.designsystem.component.DodamPageIndicator

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun DodamIndicatorPreview() {

    val pagerState = rememberPagerState {
        3
    }
    DodamTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamTheme.colors.backgroundNormal)
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxWidth(),
                state = pagerState
            ) {
                Text(text = it.toString())
            }
            DodamPageIndicator(
                modifier = Modifier.align(Alignment.End),
                pagerState = pagerState
            )
            Spacer(modifier = Modifier.height(16.dp))
            DodamLinerProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = 0.3f
            )
            Spacer(modifier = Modifier.height(8.dp))
            DodamLinerProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth(),
                progress = 0.3f,
                disabled = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            DodamCircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                progress = 0.5f,
            )
        }
    }
}