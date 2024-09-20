package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.foundation.DodamIcons


@Composable
fun DodamAvatar(
    modifier: Modifier = Modifier,
    avatarSize: AvatarSize,
    model: Any? = null,
    contentDescription: String? = null,
    colorFilter: ColorFilter? = null,
    alpha: Float = DefaultAlpha,
    contentScale: ContentScale = ContentScale.Fit,
) {

    val avatarConfig = avatarSize.getAvatarConfig()

    when (model) {
        is String, is ImageRequest -> {
            DodamAsyncAvatar(
                modifier = modifier
                    .size(avatarConfig.backgroundSize)
                    .clip(CircleShape),
                model = model,
                contentDescription = contentDescription,
                colorFilter = colorFilter,
                alpha = alpha,
                contentScale = contentScale
            )
        }
        else -> {
            Box(
                modifier = modifier
                    .size(avatarConfig.backgroundSize)
                    .background(
                        color = DodamTheme.colors.fillNormal,
                        shape = CircleShape
                    )
            ) {
                Image(
                    modifier = Modifier
                        .size(avatarConfig.iconSize)
                        .align(Alignment.Center),
                    imageVector = DodamIcons.Person.value,
                    contentDescription = contentDescription,
                    alpha = alpha,
                    colorFilter = colorFilter?: ColorFilter.tint(DodamTheme.colors.fillAlternative),
                    contentScale = contentScale
                )
            }
        }
    }
}

@Composable
private fun DodamAsyncAvatar(
    modifier: Modifier = Modifier,
    model: Any,
    contentDescription: String?,
    colorFilter: ColorFilter?,
    alpha: Float,
    contentScale: ContentScale
) {
    AsyncImage(
        modifier = modifier,
        model = model,
        contentDescription = contentDescription,
        colorFilter = colorFilter,
        alpha = alpha,
        contentScale = contentScale
    )
}

@Stable
enum class AvatarSize {
    ExtraSmall,
    Small,
    Medium,
    Large,
    ExtraLarge,
    XXL,
}

@Immutable
data class AvatarConfig(
    val backgroundSize: Dp,
    val iconSize: Dp
)



@Composable
private fun AvatarSize.getAvatarConfig() =
    when (this) {
        AvatarSize.ExtraSmall -> AvatarConfig(AvatarDefaults.ExtraSmallBackgroundSize, AvatarDefaults.ExtraSmallIconSize)
        AvatarSize.Small -> AvatarConfig(AvatarDefaults.SmallBackgroundSize, AvatarDefaults.SmallIconSize)
        AvatarSize.Medium -> AvatarConfig(AvatarDefaults.MediumBackgroundSize, AvatarDefaults.MediumIconSize)
        AvatarSize.Large -> AvatarConfig(AvatarDefaults.LargeBackgroundSize, AvatarDefaults.LargeIconSize)
        AvatarSize.ExtraLarge -> AvatarConfig(AvatarDefaults.ExtraLargeBackgroundSize, AvatarDefaults.ExtraLargeIconSize)
        AvatarSize.XXL -> AvatarConfig(AvatarDefaults.XXLBackgroundSize, AvatarDefaults.XXLIconSize)
    }

private object AvatarDefaults {
    val ExtraSmallBackgroundSize = 16.dp
    val SmallBackgroundSize = 24.dp
    val MediumBackgroundSize = 32.dp
    val LargeBackgroundSize = 36.dp
    val ExtraLargeBackgroundSize = 64.dp
    val XXLBackgroundSize = 128.dp

    val ExtraSmallIconSize = 10.dp
    val SmallIconSize = 15.dp
    val MediumIconSize = 20.dp
    val LargeIconSize = 22.5.dp
    val ExtraLargeIconSize = 40.dp
    val XXLIconSize = 80.dp
}