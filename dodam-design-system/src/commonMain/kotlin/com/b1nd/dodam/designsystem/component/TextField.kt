package com.b1nd.dodam.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.lerp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import com.b1nd.dodam.designsystem.foundation.DodamIcons
import com.b1nd.dodam.designsystem.foundation.icons.rememberIcColoredExclamationMarkCircle

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
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    cursorBrush: Brush = SolidColor(Color.Black),
    onClickRemoveRequest: () -> Unit = {},
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var isFocus by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    val currentInputType by remember(isFocus, value, isError) {
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

    val labelTextStyle = DodamTextFieldDefaults.LabelTextStyle
    val labelSmallTextStyle = DodamTextFieldDefaults.LabelSmallTextStyle
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
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.LabelColor
        },
        label = "",
    )

    val animateStrokeColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.StrokeColor
        },
        label = "",
    )

    val animateSupportTextColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
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
            textStyle = DodamTextFieldDefaults.TextStyle.copy(
                color = DodamTextFieldDefaults.TextColor
            ),
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            cursorBrush = cursorBrush,
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
                            .align(Alignment.Top)
                            .padding(top = 8.dp)
                            .size(32.dp)
                            .clickable(
                                onClick = onClickRemoveRequest,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberBounceIndication()
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isError) {
                            Image(
                                modifier = Modifier.size(24.dp),
                                imageVector = rememberIcColoredExclamationMarkCircle(
                                    backgroundColor = DodamTextFieldDefaults.ErrorColor
                                ),
                                contentDescription = null
                            )
                        } else {
                            Image(
                                modifier = Modifier.size(24.dp),
                                imageVector = DodamIcons.XMarkCircle.value,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(DodamTextFieldDefaults.LabelColor)
                            )
                        }
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

@Composable
fun DodamTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String = "",
    supportText: String = "",
    isError: Boolean = false,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    cursorBrush: Brush = SolidColor(Color.Black),
    onClickRemoveRequest: () -> Unit = {},
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var isFocus by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    val currentInputType by remember(isFocus, value, isError) {
        derivedStateOf {
            focusStateAsInputType(
                isFocused = isFocus,
                currentValue = value.text,
                isError = isError
            )
        }
    }

    val transition = updateTransition(
        targetState = when {
            currentInputType is InputType.Focus -> false
            currentInputType is InputType.UnFocus -> false
            currentInputType is InputType.Error -> false
            currentInputType is InputType.Default && value.text.isNotEmpty() -> false
            else -> true
        },
        label = "Text Transition"
    )

    val labelTextStyle = DodamTextFieldDefaults.LabelTextStyle
    val labelSmallTextStyle = DodamTextFieldDefaults.LabelSmallTextStyle
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
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.LabelColor
        },
        label = "",
    )

    val animateStrokeColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.StrokeColor
        },
        label = "",
    )

    val animateSupportTextColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
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
            textStyle = DodamTextFieldDefaults.TextStyle.copy(
                color = DodamTextFieldDefaults.TextColor
            ),
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            cursorBrush = cursorBrush,
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

                if (currentInputType !is InputType.Default && value.text.isNotEmpty() ) {

                    Box(
                        modifier = Modifier
                            .align(Alignment.Top)
                            .padding(top = 8.dp)
                            .size(32.dp)
                            .clickable(
                                onClick = onClickRemoveRequest,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberBounceIndication()
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isError) {
                            Image(
                                modifier = Modifier.size(24.dp),
                                imageVector = rememberIcColoredExclamationMarkCircle(
                                    backgroundColor = DodamTextFieldDefaults.ErrorColor
                                ),
                                contentDescription = null
                            )
                        } else {
                            Image(
                                modifier = Modifier.size(24.dp),
                                imageVector = DodamIcons.XMarkCircle.value,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(DodamTextFieldDefaults.LabelColor)
                            )
                        }
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

@Composable
fun DodamFilledTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    supportText: String = "",
    isError: Boolean = false,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    cursorBrush: Brush = SolidColor(Color.Black),
    onClickRemoveRequest: () -> Unit = {},
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var isFocus by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    val currentInputType by remember(isFocus, value, isError) {
        derivedStateOf {
            focusStateAsInputType(
                isFocused = isFocus,
                currentValue = value,
                isError = isError
            )
        }
    }

    val animateLabelColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.LabelColor
        },
        label = "",
    )

    val animateStrokeColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.StrokeColor
        },
        label = "",
    )

    val animateSupportTextColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.SupportTextColor
        },
        label = "",
    )

    val animateBackgroundColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.BackgroundFocusColor
            is InputType.Error -> DodamTextFieldDefaults.BackgroundErrorColor
            else -> DodamTextFieldDefaults.BackgroundNormal
        },
        label = "",
    )

    var boxHeight by remember { mutableStateOf(56.dp) }

    Box(
        modifier = modifier
            .heightIn(min = 56.dp)
            .alpha(if (enabled) 1f else 0.65f)
            .onGloballyPositioned { coordinates ->
                boxHeight = density.run { coordinates.size.toSize().height.toDp() }
            }
    ) {
        Column {
            Text(
                modifier = Modifier,
                text = label,
                style = DodamTextFieldDefaults.LabelSmallTextStyle,
                color = animateLabelColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            BasicTextField(
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        isFocus = it.isFocused
                    },
                value = value,
                onValueChange = onValueChange,
                textStyle = DodamTextFieldDefaults.TextStyle.copy(
                    color = DodamTextFieldDefaults.TextColor
                ),
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                cursorBrush = cursorBrush,
                enabled = enabled
            ) { innerTextField ->
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = animateStrokeColor,
                            shape = DodamTheme.shapes.medium
                        )
                        .drawBehind {
                            drawRoundRect(
                                color = animateBackgroundColor,
                                cornerRadius = CornerRadius(12.dp.toPx())
                            )
                        }
                ) {
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
                                .align(Alignment.CenterVertically)
                                .padding(
                                    start = 16.dp,
                                    top = (10.5).dp,
                                    bottom = (10.5).dp
                                )
                                .weight(1f)
                        ) {
                            innerTextField()
                        }

                        if (currentInputType !is InputType.Default && value.isNotEmpty()) {

                            Box(
                                modifier = Modifier
                                    .align(Alignment.Top)
                                    .padding(top = 8.dp)
                                    .size(32.dp)
                                    .padding(
                                        end = 12.dp
                                    )
                                    .clickable(
                                        onClick = onClickRemoveRequest,
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberBounceIndication()
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                if (isError) {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = rememberIcColoredExclamationMarkCircle(
                                            backgroundColor = DodamTextFieldDefaults.ErrorColor
                                        ),
                                        contentDescription = null
                                    )
                                } else {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = DodamIcons.XMarkCircle.value,
                                        contentDescription = null,
                                        colorFilter = ColorFilter.tint(DodamTextFieldDefaults.LabelColor)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        if (supportText.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(
                        y = boxHeight + 4.dp
                    ),
                text = supportText,
                color = animateSupportTextColor,
                style = DodamTextFieldDefaults.SupportTextStyle
            )
        }
    }
}

@Composable
fun DodamFilledTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String = "",
    supportText: String = "",
    isError: Boolean = false,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    cursorBrush: Brush = SolidColor(Color.Black),
    onClickRemoveRequest: () -> Unit = {},
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var isFocus by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    val currentInputType by remember(isFocus, value, isError) {
        derivedStateOf {
            focusStateAsInputType(
                isFocused = isFocus,
                currentValue = value.text,
                isError = isError
            )
        }
    }

    val animateLabelColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.LabelColor
        },
        label = "",
    )

    val animateStrokeColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.FocusColor
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.StrokeColor
        },
        label = "",
    )

    val animateSupportTextColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Error -> DodamTextFieldDefaults.ErrorColor
            else -> DodamTextFieldDefaults.SupportTextColor
        },
        label = "",
    )

    val animateBackgroundColor by animateColorAsState(
        targetValue = when(currentInputType) {
            is InputType.Focus -> DodamTextFieldDefaults.BackgroundFocusColor
            is InputType.Error -> DodamTextFieldDefaults.BackgroundErrorColor
            else -> DodamTextFieldDefaults.BackgroundNormal
        },
        label = "",
    )

    var boxHeight by remember { mutableStateOf(56.dp) }

    Box(
        modifier = modifier
            .heightIn(min = 56.dp)
            .alpha(if (enabled) 1f else 0.65f)
            .onGloballyPositioned { coordinates ->
                boxHeight = density.run { coordinates.size.toSize().height.toDp() }
            }
    ) {
        Column {
            Text(
                modifier = Modifier,
                text = label,
                style = DodamTextFieldDefaults.LabelSmallTextStyle,
                color = animateLabelColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            BasicTextField(
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        isFocus = it.isFocused
                    },
                value = value,
                onValueChange = onValueChange,
                textStyle = DodamTextFieldDefaults.TextStyle.copy(
                    color = DodamTextFieldDefaults.TextColor
                ),
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                cursorBrush = cursorBrush,
                enabled = enabled
            ) { innerTextField ->
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = animateStrokeColor,
                            shape = DodamTheme.shapes.medium
                        )
                        .drawBehind {
                            drawRoundRect(
                                color = animateBackgroundColor,
                                cornerRadius = CornerRadius(12.dp.toPx())
                            )
                        }
                ) {
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
                                .align(Alignment.CenterVertically)
                                .padding(
                                    start = 16.dp,
                                    top = (10.5).dp,
                                    bottom = (10.5).dp
                                )
                                .weight(1f)
                        ) {
                            innerTextField()
                        }

                        if (currentInputType !is InputType.Default && value.text.isNotEmpty()) {

                            Box(
                                modifier = Modifier
                                    .align(Alignment.Top)
                                    .padding(
                                        top = 8.dp
                                    )
                                    .size(32.dp)
                                    .padding(
                                        end = 12.dp
                                    )
                                    .clickable(
                                        onClick = onClickRemoveRequest,
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberBounceIndication()
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                if (isError) {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = rememberIcColoredExclamationMarkCircle(
                                            backgroundColor = DodamTextFieldDefaults.ErrorColor
                                        ),
                                        contentDescription = null
                                    )
                                } else {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = DodamIcons.XMarkCircle.value,
                                        contentDescription = null,
                                        colorFilter = ColorFilter.tint(DodamTextFieldDefaults.LabelColor)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        if (supportText.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(
                        y = boxHeight + 4.dp
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

    val LabelTextStyle @Composable get() = DodamTheme.typography.headlineMedium()
    val LabelSmallTextStyle @Composable get() = DodamTheme.typography.labelMedium()
    val LabelColor @Composable get() = DodamTheme.colors.labelAlternative

    val TextStyle @Composable get() = DodamTheme.typography.headlineMedium()
    val TextColor @Composable get() = DodamTheme.colors.labelStrong
    val StrokeColor @Composable get() = DodamTheme.colors.lineNormal


    val SupportTextStyle @Composable get() = DodamTheme.typography.labelMedium()
    val SupportTextColor @Composable get() = DodamTheme.colors.labelAlternative

    val BackgroundNormal @Composable get() = DodamTheme.colors.backgroundNormal
    val BackgroundFocusColor @Composable get() = Color(0x03008BFF)
    val BackgroundErrorColor @Composable get() = Color(0x03E52222)

    val ErrorColor @Composable get() = DodamTheme.colors.statusNegative
    val FocusColor @Composable get() = DodamTheme.colors.primaryNormal
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