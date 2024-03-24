package com.b1nd.dodam.dds.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.animation.bounceClick
import com.b1nd.dodam.dds.style.CheckmarkIcon
import com.b1nd.dodam.dds.theme.DodamTheme

@Composable
fun DodamCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CheckboxColors = CheckboxDefaults.colors(
        checkedColor = MaterialTheme.colorScheme.primary,
        uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant,
        checkmarkColor = MaterialTheme.colorScheme.onPrimary,
        disabledCheckedColor = MaterialTheme.colorScheme.primary.copy(0.5f),
        disabledUncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val transition = updateTransition(checked, label = "Checkbox transition")

    val checkboxColor by transition.animateColor(
        transitionSpec = {
            tween(150)
        },
        label = ""
    ) {
        if (enabled) {
            if (it) colors.checkedBoxColor else colors.uncheckedBoxColor
        } else {
            if (it) colors.disabledCheckedBoxColor else colors.disabledUncheckedBoxColor
        }
    }

    val borderColor by transition.animateColor(
        transitionSpec = {
            tween(150)
        },
        label = ""
    ) {
        if (enabled) {
            if (it) colors.checkedBorderColor else colors.uncheckedBorderColor
        } else {
            if (it) colors.disabledBorderColor else colors.disabledUncheckedBorderColor
        }
    }

    val checkmarkColor by transition.animateColor(
        transitionSpec = {
            tween(100)
        },
        label = ""
    ) {
        if (enabled) {
            if (it) colors.checkedCheckmarkColor else colors.uncheckedCheckmarkColor
        } else {
            if (it) colors.checkedCheckmarkColor.copy(0.5f) else colors.uncheckedCheckmarkColor
        }
    }

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = 40.dp,
                minHeight = 40.dp,
            )
            .bounceClick(
                onClick = {
                    if (onCheckedChange != null) {
                        onCheckedChange(!checked)
                    }
                },
                enabled = enabled,
                interactionSource = interactionSource
            )
            .padding(11.dp)
            .then(
                if (checked) {
                    Modifier
                        .background(
                            color = checkboxColor,
                            shape = RoundedCornerShape(4.dp)
                        )
                } else {
                    Modifier
                        .border(
                            width = 2.dp,
                            color = borderColor,
                            shape = RoundedCornerShape(4.dp)
                        )
                }
            )
    ) {
        CheckmarkIcon(
            modifier = Modifier.size(18.dp),
            tint = checkmarkColor
        )
    }
}

@Composable
@Preview
fun DodamCheckboxPreview() {
    var checked by remember { mutableStateOf(false) }
    DodamTheme {
        DodamCheckbox(
            checked = checked,
            { checked = it },
        )
    }
}
