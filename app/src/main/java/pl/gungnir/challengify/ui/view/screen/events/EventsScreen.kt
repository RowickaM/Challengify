package pl.gungnir.challengify.ui.view.screen.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun EventsScreen(
    scale: Float,
    onMenuClick: () -> Unit
) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .clickable { onMenuClick() },
        text = "EventsScreen Component",
        fontSize = 24.sp * scale
    )
}

@Preview
@Composable
fun EventsScreenPreview() {
    EventsScreen(1f, {})
}