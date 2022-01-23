package pl.gungnir.challengify.ui.view.screen.menu

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import pl.gungnir.challengify.ui.theme.ChallengifyTheme

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    widthContentSize: Dp
) {
    val width = widthContentSize - 15.dp
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(vertical = 80.dp)
    ) {
        val (topMenu, bottomMenu) = createRefs()

        Column(
            modifier = Modifier
                .width(width)
                .constrainAs(topMenu) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .size(Dp(width.value * 2 / 3))
                    .padding(8.dp)
                    .border(
                        width = 4.dp,
                        color = MaterialTheme.colors.onPrimary,
                        shape = CircleShape
                    ),
                imageVector = Icons.Outlined.Person,
                contentDescription = "zdjęcie użytkownika",
                tint = MaterialTheme.colors.onPrimary
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Pole 1",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body2,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Pole 2",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body2,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Pole 3",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body2,
            )
        }
        Text(
            text = "Wyloguj",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .constrainAs(bottomMenu) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(topMenu.start)
                    end.linkTo(topMenu.end)
                }
        )
    }

}

@Preview(
    name = "Menu Light Mode",
    group = "light",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun MenuScreenPreview() {
    ChallengifyTheme {
        MenuScreen(widthContentSize = 200.dp)
    }
}

@Preview(
    name = "Menu Dark Mode",
    group = "dark",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun MenuScreenDarkPreview() {
    ChallengifyTheme {
        MenuScreen(widthContentSize = 200.dp)
    }
}