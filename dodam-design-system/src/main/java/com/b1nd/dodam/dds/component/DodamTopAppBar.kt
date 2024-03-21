package com.b1nd.dodam.dds.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.component.button.DodamIconButton
import com.b1nd.dodam.dds.style.ArrowLeftIcon
import com.b1nd.dodam.dds.style.BellIcon
import com.b1nd.dodam.dds.style.HeadlineMedium
import com.b1nd.dodam.dds.style.HeadlineSmall
import com.b1nd.dodam.dds.style.PlusIcon
import com.b1nd.dodam.dds.style.TitleMedium
import com.b1nd.dodam.dds.theme.DodamTheme

@ExperimentalMaterial3Api
@Composable
fun DodamTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.surface,
        scrolledContainerColor = MaterialTheme.colorScheme.surface,
        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
        titleContentColor = MaterialTheme.colorScheme.onSurface,
        actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = { HeadlineSmall(text = title) },
        modifier = modifier,
        actions = actions,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

@ExperimentalMaterial3Api
@Composable
fun DodamSmallTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.surface,
        scrolledContainerColor = MaterialTheme.colorScheme.surface,
        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
        titleContentColor = MaterialTheme.colorScheme.onSurface,
        actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = { TitleMedium(text = title) },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick
            ) {
                ArrowLeftIcon(tint = colors.navigationIconContentColor)
            }
        },
        actions = actions,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

@ExperimentalMaterial3Api
@Composable
fun DodamMediumTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.surface,
        scrolledContainerColor = MaterialTheme.colorScheme.surface,
        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
        titleContentColor = MaterialTheme.colorScheme.onSurface,
        actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    MediumTopAppBar(
        title = { HeadlineSmall(text = title) },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick
            ) {
                ArrowLeftIcon(tint = colors.navigationIconContentColor)
            }
        },
        actions = actions,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

@ExperimentalMaterial3Api
@Composable
fun DodamLargeTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.surface,
        scrolledContainerColor = MaterialTheme.colorScheme.surface,
        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
        titleContentColor = MaterialTheme.colorScheme.onSurface,
        actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    LargeTopAppBar(
        title = { HeadlineMedium(text = title) },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick
            ) {
                ArrowLeftIcon(tint = colors.navigationIconContentColor)
            }
        },
        actions = actions,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

@ExperimentalMaterial3Api
@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun DodamTopAppBarPreview() {
    DodamTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DodamTopAppBar(
                title = "Headline Small",
                actions = {
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        PlusIcon()
                    }
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        BellIcon()
                    }
                }
            )
            DodamSmallTopAppBar(
                title = "Title Medium",
                onNavigationIconClick = { /*TODO*/ },
                actions = {
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        PlusIcon()
                    }
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        BellIcon()
                    }
                }
            )
            DodamMediumTopAppBar(
                title = "Headline Small",
                onNavigationIconClick = { /*TODO*/ },
                actions = {
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        PlusIcon()
                    }
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        BellIcon()
                    }
                }
            )
            DodamLargeTopAppBar(
                title = "Headline Medium",
                onNavigationIconClick = { /*TODO*/ },
                actions = {
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        PlusIcon()
                    }
                    DodamIconButton(onClick = { /*TODO*/ }) {
                        BellIcon()
                    }
                }
            )
        }
    }
}
