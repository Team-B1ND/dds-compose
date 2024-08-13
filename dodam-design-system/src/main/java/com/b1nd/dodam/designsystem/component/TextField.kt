package com.b1nd.dodam.designsystem.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.lerp
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.toSize
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.R
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication

sealed interface InputType {
    data object Default : InputType
    data object UnFocus : InputType
    data object Focus : InputType
    data object Error: InputType
}

@Composable
fun DodamTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    supportText: String = "",
    isError: Boolean = false,
    enabled: Boolean = true,
    onClickRemoveRequest: () -> Unit = {},
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var isFocus by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    val currentInputType by remember {
        derivedStateOf {
            focusStateAsInputType(
                isFocused = isFocus,
                currentValue = value,
                isError = isError
            )
        }
    }

    val transition = updateTransition(
        targetState = when {
            currentInputType is InputType.Focus -> false
            currentInputType is InputType.UnFocus -> false
            currentInputType is InputType.Error -> false
            currentInputType is InputType.Default && value.isNotEmpty() -> false
            else -> true
        },
        label = "Text Transition"
    )

    val labelTextStyle = DodamTextFieldDefaults.labelTextStyle
    val labelSmallTextStyle = DodamTextFieldDefaults.labelSmallTextStyle
    val labelAnimation = remember { Animatable(0f) }
    val labelAnimTextStyle by remember(labelAnimation.value) {
        derivedStateOf {
            lerp(labelTextStyle, labelSmallTextStyle, labelAnimation.value)
        }
    }

    val labelYOffsetAnimation by transition.animateDp(
        label = "",
        targetValueByState = { targetState ->
            if (targetState) 10.dp else 0.dp
        }
    )

    val animateLabelColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.focusColor
            is InputType.Error -> DodamTextFieldDefaults.errorColor
            else -> DodamTextFieldDefaults.LabelColor
        },
        label = "",
    )

    val animateStrokeColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.focusColor
            is InputType.Error -> DodamTextFieldDefaults.errorColor
            else -> DodamTextFieldDefaults.StrokeColor
        },
        label = "",
    )

    val animateSupportTextColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Error -> DodamTextFieldDefaults.errorColor
            else -> DodamTextFieldDefaults.SupportTextColor
        },
        label = "",
    )

    LaunchedEffect(key1 = transition.targetState) {
        labelAnimation.snapTo(if (transition.targetState) 0f else 1f)
    }

    var boxHeight by remember { mutableStateOf(56.dp) }
    Box(
        modifier = modifier
            .heightIn(min = 56.dp)
            .alpha(if (enabled) 1f else 0.65f)
            .onGloballyPositioned { coordinates ->
                boxHeight = density.run { coordinates.size.toSize().height.toDp() }
            }
    ) {
        BasicTextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocus = it.isFocused
                },
            value = value,
            onValueChange = onValueChange,
            textStyle = DodamTextFieldDefaults.textStyle.copy(
                color = DodamTextFieldDefaults.textColor
            ),
            enabled = enabled
        ) { innerTextField ->
            Row(
                modifier = Modifier
                    .heightIn(
                        min = 48.dp
                    )
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .heightIn(
                            min = 48.dp
                        )
                        .weight(1f)
                ) {
                    Text(
                        modifier = Modifier
                            .offset(
                                y = labelYOffsetAnimation
                            ),
                        text = label,
                        style = labelAnimTextStyle,
                        color = animateLabelColor
                    )
                    Box(modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                    ) {
                        innerTextField()
                    }
                }

                if (currentInputType !is InputType.Default && value.isNotEmpty() ) {

                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(32.dp)
                            .clickable(
                                onClick = onClickRemoveRequest,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberBounceIndication()
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = if (isError) R.drawable.ic_colored_exclamationmark_circle else R.drawable.ic_xmark_circle),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(if (isError) DodamTextFieldDefaults.errorColor else DodamTextFieldDefaults.LabelColor)
                        )
                    }
                }
            }
        }
        Box(
            modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(1.dp)
                .background(animateStrokeColor)
        )
        if (supportText.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(
                        y = boxHeight + 8.dp
                    ),
                text = supportText,
                color = animateSupportTextColor,
                style = DodamTextFieldDefaults.SupportTextStyle
            )
        }
    }
}


@Stable
object DodamTextFieldDefaults {

    val labelTextStyle @Composable get() = DodamTheme.typography.headlineMedium
    val labelSmallTextStyle @Composable get() = DodamTheme.typography.labelMedium
    val LabelColor @Composable get() = DodamTheme.colors.labelAlternative

    val textStyle @Composable get() = DodamTheme.typography.headlineMedium
    val textColor @Composable get() = DodamTheme.colors.labelStrong
    val StrokeColor @Composable get() = DodamTheme.colors.labelNormal

    val SupportTextStyle @Composable get() = DodamTheme.typography.labelMedium
    val SupportTextColor @Composable get() = DodamTheme.colors.labelAlternative

    val errorColor @Composable get() = DodamTheme.colors.statusNegative
    val focusColor @Composable get() = DodamTheme.colors.primaryNormal
}

private fun focusStateAsInputType(
    isFocused: Boolean,
    currentValue: String,
    isError: Boolean
): InputType =
    if (isError) {
        InputType.Error
    } else if (isFocused) {
        InputType.Focus
    } else if (currentValue.isNotBlank()) {
        InputType.UnFocus
    } else if (currentValue.isBlank()) {
        InputType.Default
    } else {
        InputType.Default
    }

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0xFF232424)
private fun DodamTextFieldPreview() {
    val focusManager = LocalFocusManager.current
    var value by remember { mutableStateOf("") }
    DodamTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                    })
                }
        ) {
            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = false,
                enabled = true,
                supportText = "",
                onClickRemoveRequest = {}
            )

            Spacer(modifier = Modifier.height(24.dp))

            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = false,
                enabled = true,
                supportText = "Supporting text",
                onClickRemoveRequest = {}
            )

            Spacer(modifier = Modifier.height(24.dp))

            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = true,
                enabled = true,
                supportText = "",
                onClickRemoveRequest = {}
            )
            Spacer(modifier = Modifier.height(24.dp))
            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = true,
                enabled = true,
                supportText = "Supporting text",
                onClickRemoveRequest = {}
            )
        }
    }
}