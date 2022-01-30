package pl.gungnir.challengify.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.challengify.ui.theme.ChallengifyTheme
import pl.gungnir.challengify.ui.view.screen.menu.MenuScreen
import pl.gungnir.challengify.utils.helper.nonRippleClickable
import pl.gungnir.challengify.utils.nav.destination.NavigationDirection

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val animationDuration = 300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mViewModel: MainViewModel = hiltViewModel()
            val navController: NavHostController = rememberNavController()

            val (drawerState, setDrawerState) = remember { mutableStateOf(false) }
            val scaleAnimation by animateFloatAsState(
                targetValue = if (drawerState) 0.8f else 1f,
                animationSpec = tween(durationMillis = animationDuration)
            )
            val offsetAnimation by animateDpAsState(
                targetValue = if (drawerState) 250.dp else 0.dp,
                animationSpec = tween(durationMillis = animationDuration)
            )

            ChallengifyTheme {
                Box(modifier = Modifier.fillMaxSize()) {

                    MenuScreen(widthContentSize = 250.dp)

                    NavHostView(
                        modifier = Modifier
                            .scale(scaleAnimation)
                            .offset(x = offsetAnimation)
                            .background(Color.White)
                            .nonRippleClickable {
                                if (drawerState) {
                                    setDrawerState(false)
                                }
                            },
                        initialNav = NavigationDirection.started,
                        navController = navController,
                        scale = scaleAnimation,
                        onMenuClick = { setDrawerState(!drawerState) }
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