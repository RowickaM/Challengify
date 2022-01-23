package pl.gungnir.challengify.ui.activity

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.gungnir.challengify.ui.view.screen.events.EventsScreen
import pl.gungnir.challengify.utils.nav.destination.NavigationCommand
import pl.gungnir.challengify.utils.nav.destination.NavigationDirection

@Composable
fun NavHostView(
    modifier: Modifier,
    initialNav: NavigationCommand,
    navController: NavHostController,
    scale: Float,
    onMenuClick: () -> Unit,
) {
    NavHost(
        navController = navController,
        modifier = modifier
            .shadow(elevation = 4.dp)
            .background(Color.White),
        startDestination = initialNav.destination
    ) {
        composable(route = NavigationDirection.started.destination) {
            EventsScreen(
                scale,
                onMenuClick
            )
        }
    }
}