package pl.gungnir.challengify.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    onPrimary = Gray,
    secondary = Orange,
    onSecondary = Color.White,
    background = Gray,
    onBackground = Color.White,
    surface = Color.White,
    onSurface = Gray,
)
private val LightColorPalette = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    onPrimary = Gray,
    secondary = Orange,
    onSecondary = Color.White,
    background = Color.White,
    onBackground = Gray,
    surface = Color.White,
    onSurface = Gray,
)

@Composable
fun ChallengifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}