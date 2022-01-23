package pl.gungnir.challengify.ui.activity

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pl.gungnir.challengify.utils.nav.destination.NavigationCommand

@Composable
fun NavHostView(
    modifier: Modifier,
    initialNav: NavigationCommand,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = initialNav.destination
    ) {

    }
}