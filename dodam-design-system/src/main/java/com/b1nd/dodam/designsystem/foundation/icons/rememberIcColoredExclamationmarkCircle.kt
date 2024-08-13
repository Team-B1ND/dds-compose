package com.b1nd.dodam.designsystem.foundation.icons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


@Composable
fun rememberIcColoredExclamationMarkCircle(
	contentColor: Color = Color(0xFFFFFFFF),
	backgroundColor: Color = Color(0xFFFBD300)
): ImageVector {
    return remember {
        ImageVector.Builder(
                name = "ColoredExclamationMarkCircle",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
				path(
    				fill = SolidColor(contentColor),
    				fillAlpha = 1.0f,
    				stroke = null,
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 1.0f,
    				strokeLineCap = StrokeCap.Butt,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(0f, 0f)
					horizontalLineTo(12f)
					verticalLineTo(12f)
					horizontalLineTo(0f)
					verticalLineTo(0f)
					close()
}
				group {
					path(
    					fill = SolidColor(backgroundColor),
    					fillAlpha = 1.0f,
    					stroke = null,
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(21.6481f, 11.997f)
						curveTo(21.6481f, 17.4659f, 17.205f, 21.9939f, 11.8232f, 21.9939f)
						curveTo(6.4509f, 21.9939f, 2f, 17.4659f, 2f, 11.997f)
						curveTo(2f, 6.52f, 6.4432f, 2f, 11.8154f, 2f)
						curveTo(17.1971f, 2f, 21.6481f, 6.52f, 21.6481f, 11.997f)
						close()
						moveTo(10.6588f, 15.8973f)
						curveTo(10.6588f, 16.5292f, 11.1876f, 17.0026f, 11.8266f, 17.0026f)
						curveTo(12.464f, 17.0026f, 12.9894f, 16.5372f, 12.9894f, 15.8973f)
						curveTo(12.9894f, 15.2626f, 12.4718f, 14.7877f, 11.8266f, 14.7877f)
						curveTo(11.1798f, 14.7877f, 10.6588f, 15.2689f, 10.6588f, 15.8973f)
						close()
						moveTo(10.7983f, 7.8962f)
						lineTo(10.9321f, 12.7788f)
						curveTo(10.9502f, 13.3527f, 11.2671f, 13.6681f, 11.8266f, 13.6681f)
						curveTo(12.3654f, 13.6681f, 12.6807f, 13.3623f, 12.6987f, 12.7753f)
						lineTo(12.8404f, 7.9041f)
						curveTo(12.8585f, 7.3128f, 12.4223f, 6.8918f, 11.8154f, 6.8918f)
						curveTo(11.2024f, 6.8918f, 10.7802f, 7.3049f, 10.7983f, 7.8962f)
						close()
}
}
}.build()
    }
}

