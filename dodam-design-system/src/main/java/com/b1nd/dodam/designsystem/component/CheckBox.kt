package com.b1nd.dodam.designsystem.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import com.b1nd.dodam.designsystem.foundation.DodamIcons

@Composable
fun DodamCheckBox(
    onClick: () -> Unit,
    checked: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isError: Boolean = false,
) {
    val transition = updateTransition(targetState = checked, label = "CheckBox Transition")
    val color by transition.animateColor(label = "CheckBox Color") { isChecked ->
        if (isChecked) {
            CheckBoxDefaults.CheckedCheckBoxColor.takeIf { !isError }
                ?: CheckBoxDefaults.ErrorCheckBoxColor
        } else {
            CheckBoxDefaults.CheckedCheckBoxColor.copy(0f).takeIf { !isError }
                ?: CheckBoxDefaults.ErrorCheckBoxColor.copy(0f)
        }
    }
    val border by transition.animateColor(label = "CheckBox Border") { isChecked ->
        if (!isChecked) {
            CheckBoxDefaults.CheckBoxBorderColor
        } else {
            CheckBoxDefaults.CheckBoxBorderColor.copy(0f)
        }

    }

    Surface(
        modifier = modifier
            .clickable(
                onClick = onClick,
                enabled = enabled,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberBounceIndication(
                    radius = CheckBoxDefaults.CheckBoxShape,
                    showBackground = false
                )
            )
            .alpha(if (enabled) 1f else CheckBoxDefaults.DISABLE_OPACITY)
            .padding(CheckBoxDefaults.CheckBoxContainerPadding),
        color = color,
        shape = CheckBoxDefaults.CheckBoxShape,
        border = BorderStroke(
            width = CheckBoxDefaults.CheckBoxBorderSize,
            color = border
        )
    ) {
        Box(
            modifier = Modifier
                .size(CheckBoxDefaults.CheckBoxSize),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = transition.targetState,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                Icon(
                    imageVector = DodamIcons.Checkmark.value,
                    contentDescription = "Checkmark",
                    tint = DodamTheme.colors.staticWhite,
                    modifier = Modifier.size(CheckBoxDefaults.CheckmarkSize)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0xFF232323)
private fun DodamCheckBoxPreview() {
    DodamTheme {
        var checked by remember { mutableStateOf(false) }

        DodamCheckBox(
            onClick = { checked = !checked },
            checked = checked,
        )
    }
}

private object CheckBoxDefaults {
    val CheckBoxContainerPadding = PaddingValues(3.dp)
    val CheckBoxBorderColor @Composable get() = DodamTheme.colors.lineNormal
    val CheckBoxBorderSize = 2.dp
    val CheckBoxShape = RoundedCornerShape(4.dp)
    val CheckBoxSize = 18.dp
    val CheckedCheckBoxColor @Composable get() = DodamTheme.colors.primaryNormal
    val ErrorCheckBoxColor @Composable get() = DodamTheme.colors.statusNegative

    val CheckmarkSize = 12.dp

    const val DISABLE_OPACITY = 0.5f
}