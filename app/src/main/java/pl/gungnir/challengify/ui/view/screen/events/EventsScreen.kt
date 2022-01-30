package pl.gungnir.challengify.ui.view.screen.events

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.challengify.data.model.EventShort
import pl.gungnir.challengify.data.model.EventType
import pl.gungnir.challengify.ui.components.StaggeredVerticalGrid
import pl.gungnir.challengify.ui.view.screen.events.components.EventItemView

@Composable
fun EventsScreen(
    scale: Float,
    onMenuClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Icon(
            modifier = Modifier
                .padding(8.dp)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colors.onBackground,
                    shape = RoundedCornerShape(8.dp)
                )
                .scale(scale)
                .clickable(onClick = onMenuClick)
                .padding(8.dp),
            imageVector = Icons.Outlined.Menu,
            contentDescription = "menu"
        )

        StaggeredVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale),
            columns = 2
        ) {
            (0..eventsShort.lastIndex).forEach {
                EventItemView(
                    modifier = Modifier.padding(8.dp),
                    event = eventsShort[it]
                )
            }
        }
    }
}

@Preview
@Composable
fun EventsScreenPreview() {
    EventsScreen(1f, {})
}

private val eventsShort = listOf(
    EventShort(
        id = "15DF48E",
        title = "Przeczytam 50 stron",
        type = EventType.PERCENT,
        progress = "92",
        isDone = false
    ),
    EventShort(
        id = "15DD34E",
        title = "Codzienne ćwiczenia",
        type = EventType.INCREMENTAL,
        progress = "100",
        isDone = true
    ),
    EventShort(
        id = "13DF48E",
        title = "Legacy challenge TS2",
        type = EventType.PERCENT,
        progress = "100",
        isDone = true
    ),
    EventShort(
        id = "15BB34E",
        title = "Codzienne uczenie się wspaniałego języka programowania - Kotlin",
        type = EventType.INCREMENTAL,
        progress = "10",
        isDone = false
    ),
    EventShort(
        id = "15DF17D",
        title = "Nauczenie sieę grać piosenki \"Wlaz kotek na płotek\"",
        type = EventType.PERCENT,
        progress = "100",
        isDone = false
    ),
)