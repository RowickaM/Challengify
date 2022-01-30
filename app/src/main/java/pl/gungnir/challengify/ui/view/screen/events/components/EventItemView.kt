package pl.gungnir.challengify.ui.view.screen.events.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.challengify.data.model.EventShort
import pl.gungnir.challengify.data.model.EventType
import pl.gungnir.challengify.ui.theme.ChallengifyTheme
import pl.gungnir.challengify.ui.theme.Green

@Composable
fun EventItemView(
    modifier: Modifier = Modifier,
    event: EventShort
) {
    val backgroundColor = if (event.isDone) {
        Green
    } else {
        MaterialTheme.colors.background
    }
    val textColor = if (event.isDone) {
        Color.White
    } else {
        MaterialTheme.colors.onBackground
    }
    val suffix = if (event.type == EventType.PERCENT) {
        "%"
    } else {
        "dni"
    }
    Column(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                horizontal = 24.dp,
                vertical = 16.dp
            )
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "${event.progress} $suffix",
            color = textColor,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = event.title,
            color = textColor,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    group = "light"
)
@Composable
fun EventItemDoneViewLightPreview() {
    ChallengifyTheme {
        EventItemView(
            event = EventShort(
                id = "15DF48E",
                title = "Przeczytam 50 stron",
                type = EventType.INCREMENTAL,
                progress = "12",
                isDone = true
            )
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    group = "light"
)
@Composable
fun EventItemViewLightPreview() {
    ChallengifyTheme {
        EventItemView(
            event = EventShort(
                id = "15DF48E",
                title = "Przeczytam 50 stron",
                type = EventType.INCREMENTAL,
                progress = "12",
                isDone = false
            )
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    group = "dark"
)
@Composable
fun EventItemDoneViewDarkPreview() {
    ChallengifyTheme {
        EventItemView(
            event = EventShort(
                id = "15DF48E",
                title = "Przeczytam 50 stron",
                type = EventType.INCREMENTAL,
                progress = "12",
                isDone = true
            )
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    group = "dark"
)
@Composable
fun EventItemViewDarkPreview() {
    ChallengifyTheme {
        EventItemView(
            event = EventShort(
                id = "15DF48E",
                title = "Przeczytam 50 stron",
                type = EventType.INCREMENTAL,
                progress = "12",
                isDone = false
            )
        )
    }
}