package com.b1nd.dodam.dds.component.button

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.animation.LoadingDotsIndicator
import com.b1nd.dodam.dds.animation.bounceClick
import com.b1nd.dodam.dds.style.BodyLarge
import com.b1nd.dodam.dds.style.BodyMedium
import com.b1nd.dodam.dds.style.BodySmall
import com.b1nd.dodam.dds.theme.DodamTheme

@Composable
fun BoxScope.DodamCTAButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.5f),
        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(0.5f)
    ),
    elevation: Float = 0.0f,
    border: BorderStroke? = null,
    showBackground: Boolean = false,
    backgroundPadding: PaddingValues = PaddingValues(16.dp, 24.dp, 16.dp, 8.dp),
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .then(
                if (showBackground) Modifier.background(
                    Brush.verticalGradient(
                        listOf(
                            backgroundColor.copy(alpha = 0f),
                            backgroundColor
                        )
                    )
                ) else Modifier
            )
            .padding(backgroundPadding),
    ) {
        Box(
            modifier = modifier
                .minimumInteractiveComponentSize()
                .graphicsLayer(shadowElevation = elevation, shape = shape, clip = false)
                .then(if (border != null) Modifier.border(border, shape) else Modifier)
                .background(
                    color = if (!isLoading && enabled) colors.containerColor else colors.disabledContainerColor,
                    shape = shape
                )
                .clip(shape)
                .bounceClick(
                    interactionSource = interactionSource,
                    indication = null,
                    interactionColor = Color.Transparent,
                    enabled = !isLoading && enabled,
                    onClick = onClick,
                    role = Role.Button
                ),
            propagateMinConstraints = true
        ) {
            Row(
                Modifier
                    .defaultMinSize(minHeight = 58.dp)
                    .fillMaxWidth()
                    .padding(contentPadding)
                    .animateContentSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    if (isLoading) {
                        LoadingDotsIndicator()
                    } else {
                        CompositionLocalProvider(
                            LocalContentColor provides if (enabled) colors.contentColor else colors.disabledContentColor,
                            LocalTextStyle provides MaterialTheme.typography.bodyLarge,
                            content = { content() }
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun DodamCTAButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.5f),
        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(0.5f)
    ),
    elevation: Float = 0.0f,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .graphicsLayer(shadowElevation = elevation, shape = shape, clip = false)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(
                color = if (!isLoading && enabled) colors.containerColor else colors.disabledContainerColor,
                shape = shape
            )
            .clip(shape)
            .bounceClick(
                interactionSource = interactionSource,
                indication = null,
                interactionColor = Color.Transparent,
                enabled = !isLoading && enabled,
                onClick = onClick,
                role = Role.Button
            ),
        propagateMinConstraints = true
    ) {
        Row(
            Modifier
                .defaultMinSize(minHeight = 58.dp)
                .fillMaxWidth()
                .padding(contentPadding)
                .animateContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = {
                if (isLoading) {
                    LoadingDotsIndicator()
                } else {
                    CompositionLocalProvider(
                        LocalContentColor provides if (enabled) colors.contentColor else colors.disabledContentColor,
                        LocalTextStyle provides MaterialTheme.typography.bodyLarge,
                        content = { content() }
                    )
                }
            }
        )
    }
}

@Composable
fun DodamSmallFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.5f),
        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(0.5f)
    ),
    elevation: Float = 0.0f,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .graphicsLayer(shadowElevation = elevation, shape = shape, clip = false)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(
                color = if (!isLoading && enabled) colors.containerColor else colors.disabledContainerColor,
                shape = shape
            )
            .clip(shape)
            .bounceClick(
                interactionSource = interactionSource,
                indication = null,
                interactionColor = Color.Transparent,
                enabled = !isLoading && enabled,
                onClick = onClick,
                role = Role.Button
            ),
        propagateMinConstraints = true
    ) {
        Row(
            Modifier
                .defaultMinSize(minHeight = 36.dp)
                .padding(contentPadding)
                .animateContentSize(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            content = {
                if (isLoading) {
                    LoadingDotsIndicator()
                } else {
                    CompositionLocalProvider(
                        LocalContentColor provides if (enabled) colors.contentColor else colors.disabledContentColor,
                        LocalTextStyle provides MaterialTheme.typography.bodySmall,
                        content = { content() }
                    )
                }
            }
        )
    }
}

@Composable
fun DodamMediumFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.5f),
        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(0.5f)
    ),
    elevation: Float = 0.0f,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .graphicsLayer(shadowElevation = elevation, shape = shape, clip = false)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(
                color = if (!isLoading && enabled) colors.containerColor else colors.disabledContainerColor,
                shape = shape
            )
            .clip(shape)
            .bounceClick(
                interactionSource = interactionSource,
                indication = null,
                interactionColor = Color.Transparent,
                enabled = !isLoading && enabled,
                onClick = onClick,
                role = Role.Button
            ),
        propagateMinConstraints = true
    ) {
        Row(
            Modifier
                .defaultMinSize(minHeight = 40.dp)
                .padding(contentPadding)
                .animateContentSize(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            content = {
                if (isLoading) {
                    LoadingDotsIndicator()
                } else {
                    CompositionLocalProvider(
                        LocalContentColor provides if (enabled) colors.contentColor else colors.disabledContentColor,
                        LocalTextStyle provides MaterialTheme.typography.bodyMedium,
                        content = { content() }
                    )
                }
            }
        )
    }
}

@Composable
fun DodamLargeFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.5f),
        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(0.5f)
    ),
    elevation: Float = 0.0f,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .graphicsLayer(shadowElevation = elevation, shape = shape, clip = false)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(
                color = if (!isLoading && enabled) colors.containerColor else colors.disabledContainerColor,
                shape = shape
            )
            .clip(shape)
            .bounceClick(
                interactionSource = interactionSource,
                indication = null,
                interactionColor = Color.Transparent,
                enabled = !isLoading && enabled,
                onClick = onClick,
                role = Role.Button
            ),
        propagateMinConstraints = true
    ) {
        Row(
            Modifier
                .defaultMinSize(minHeight = 50.dp)
                .padding(contentPadding)
                .animateContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = {
                if (isLoading) {
                    LoadingDotsIndicator()
                } else {
                    CompositionLocalProvider(
                        LocalContentColor provides if (enabled) colors.contentColor else colors.disabledContentColor,
                        LocalTextStyle provides MaterialTheme.typography.bodySmall,
                        content = { content() }
                    )
                }
            }
        )
    }
}

@Composable
fun DodamTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .bounceClick(
                onClick = onClick,
                enabled = enabled,
                interactionSource = interactionSource
            )
            .padding(contentPadding)
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onSurface,
            LocalTextStyle provides MaterialTheme.typography.bodyLarge,
            content = content
        )
    }
}

@Composable
@Preview
private fun DodamTextButtonPreview() {
    DodamTheme {
        DodamTextButton(onClick = { /*TODO*/ }) {
            Text(text = "Text button")
        }
    }
}

@Composable
@Preview
private fun DodamCTAButtonPreview() {
    DodamTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            DodamCTAButton(onClick = { /*TODO*/ }, content = { BodyLarge(text = "Filled button") })
        }
    }
}

@Composable
@Preview
private fun DodamFilledButtonPreview() {
    DodamTheme {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            DodamSmallFilledButton(
                onClick = { /*TODO*/ },
                content = { BodySmall(text = "Filled button") },
            )
            DodamMediumFilledButton(
                onClick = { /*TODO*/ },
                content = { BodySmall(text = "Filled button") },
            )
            DodamLargeFilledButton(
                onClick = { /*TODO*/ },
                content = { BodyMedium(text = "Filled button") },
            )
            DodamCTAButton(onClick = { /*TODO*/ }, content = { BodyLarge(text = "Filled button") })
        }
    }
}

@Composable
@Preview
private fun DodamFilledButtonDisabledPreview() {
    DodamTheme {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            DodamSmallFilledButton(
                onClick = { /*TODO*/ },
                content = { BodySmall(text = "Filled button") }, enabled = false
            )
            DodamMediumFilledButton(
                onClick = { /*TODO*/ },
                content = { BodySmall(text = "Filled button") }, enabled = false
            )
            DodamLargeFilledButton(
                onClick = { /*TODO*/ },
                content = { BodyMedium(text = "Filled button") }, enabled = false
            )
            DodamCTAButton(
                onClick = { /*TODO*/ },
                content = { BodyLarge(text = "Filled button") },
                enabled = false
            )
        }
    }
}

@Composable
@Preview
private fun DodamFilledButtonLoadingPreview() {
    DodamTheme {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            DodamSmallFilledButton(
                onClick = { /*TODO*/ },
                content = { BodySmall(text = "Filled button") }, isLoading = true
            )
            DodamMediumFilledButton(
                onClick = { /*TODO*/ },
                content = { BodySmall(text = "Filled button") }, isLoading = true
            )
            DodamLargeFilledButton(
                onClick = { /*TODO*/ },
                content = { BodyMedium(text = "Filled button") }, isLoading = true

            )
            DodamCTAButton(
                onClick = { /*TODO*/ },
                content = { BodyLarge(text = "Filled button") },
                isLoading = true
            )
        }
    }
}
