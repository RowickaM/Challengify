package pl.gungnir.challengify.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.challengify.ui.theme.ChallengifyTheme
import pl.gungnir.challengify.utils.nav.destination.NavigationDirection

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mViewModel: MainViewModel = hiltViewModel()
            val navController: NavHostController = rememberNavController()

            ChallengifyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    NavHostView(
                        modifier = Modifier.padding(bottom = 56.dp),
                        initialNav = NavigationDirection.started,
                        navController = navController,
                    )

                    mViewModel.router.collectAsState().value.apply {
                        if (destination != navController.currentDestination?.route) {
                            navController.navigate(destination)
                        }
                    }
                }
            }
        }
    }
}