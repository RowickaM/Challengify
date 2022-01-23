package pl.gungnir.challengify.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF333333),
    primaryVariant = Color(0xFF333333),
    onPrimary = Color.White,
    secondary = Color(0xFFFF6B35),
    onSecondary = Color.White,
    background = Color(0xFF333333),
    onBackground = Color.White,
    surface = Color.White,
    onSurface = Color.Black,
)

private val LightColorPalette = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    onPrimary = Color(0xFF333333),
    secondary = Color(0xFFFF6B35),
    onSecondary = Color.White,
    background = Color.White,
    onBackground = Color(0xFF333333),
    surface = Color.White,
    onSurface = Color(0xFF333333),
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