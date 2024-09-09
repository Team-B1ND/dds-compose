package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.foundation.DodamIcons
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.jetbrains.compose.ui.tooling.preview.Preview

@Stable
enum class TopAppBarType {
    Large,
    Medium,
    Small,
}

@Composable
fun DodamDefaultTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    actionIcons: ImmutableList<ActionIcon> = persistentListOf(),
) {
    DodamTopAppBarImpl(
        modifier = modifier,
        actionIcons = actionIcons,
    ) {
        Row(
            modifier = Modifier
                .height(TopAppBarDefaults.MinimumContentHeight)
                .padding(start = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(TopAppBarDefaults.TitleStartSpacing))
            Text(
                text = title,
                style = TopAppBarDefaults.DefaultTopAppBarTextStyle,
                color = TopAppBarDefaults.TopAppBarTitleColor,
            )
        }
    }
}


@Composable
fun DodamTopAppBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: TopAppBarType = TopAppBarType.Small,
    actionIcons: ImmutableList<ActionIcon> = persistentListOf(),
) {
    DodamTopAppBarImpl(
        modifier = modifier,
        actionIcons = actionIcons,
    ) {
        when (type) {
            TopAppBarType.Large -> {
                Column {
                    DodamIconButton(
                        onClick = onBackClick,
                        icon = DodamIcons.ArrowLeft,
                        type = IconButtonType.Strong,
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Row {
                        Spacer(modifier = Modifier.width(TopAppBarDefaults.TitleStartSpacing))
                        Text(
                            text = title,
                            style = TopAppBarDefaults.LargeTopAppBarTextStyle,
                            color = TopAppBarDefaults.TopAppBarTitleColor,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            TopAppBarType.Medium -> {
                Column {
                    DodamIconButton(
                        onClick = onBackClick,
                        icon = DodamIcons.ArrowLeft,
                        type = IconButtonType.Strong,
                    )
                    Row {
                        Spacer(modifier = Modifier.width(TopAppBarDefaults.TitleStartSpacing))
                        Text(
                            text = title,
                            style = TopAppBarDefaults.MediumTopAppBarTextStyle,
                            color = TopAppBarDefaults.TopAppBarTitleColor,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            TopAppBarType.Small -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    DodamIconButton(
                        onClick = onBackClick,
                        icon = DodamIcons.ArrowLeft,
                        type = IconButtonType.Strong,
                    )
                    Text(
                        text = title,
                        style = TopAppBarDefaults.SmallTopAppBarTextStyle,
                        color = TopAppBarDefaults.TopAppBarTitleColor,
                    )
                }
            }
        }
    }
}

@Composable
fun DodamContentTopAppBar(
    content: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    actionIcons: ImmutableList<ActionIcon> = persistentListOf(),
) {
    DodamTopAppBarImpl(
        modifier = modifier,
        actionIcons = actionIcons,
    ) {
        Row(
            modifier = Modifier.height(TopAppBarDefaults.MinimumContentHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            content()
        }
    }
}

@Composable
private fun DodamTopAppBarImpl(
    modifier: Modifier = Modifier,
    actionIcons: ImmutableList<ActionIcon> = persistentListOf(),
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(TopAppBarDefaults.ContainerPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        content()

        Row(
            modifier = Modifier.height(TopAppBarDefaults.MinimumContentHeight),
        ) {
            actionIcons.fastForEach { icon ->
                DodamIconButton(
                    onClick = icon.onClick,
                    icon = icon.icon,
                    enabled = icon.enabled,
                )
            }
        }
    }
}

@Immutable
data class ActionIcon(
    val icon: DodamIcons,
    val onClick: () -> Unit,
    val enabled: Boolean = true,
)

private object TopAppBarDefaults {
    val ContainerPadding = PaddingValues(horizontal = 4.dp, vertical = 6.dp)
    val MinimumContentHeight = 48.dp

    val DefaultTopAppBarTextStyle @Composable get() = DodamTheme.typography.title3Bold()
    val SmallTopAppBarTextStyle @Composable get() = DodamTheme.typography.headlineBold()
    val MediumTopAppBarTextStyle @Composable get() = DodamTheme.typography.title3Bold()
    val LargeTopAppBarTextStyle @Composable get() = DodamTheme.typography.title2Bold()

    val TopAppBarTitleColor @Composable get() = DodamTheme.colors.labelStrong

    val TitleStartSpacing = 12.dp
}
