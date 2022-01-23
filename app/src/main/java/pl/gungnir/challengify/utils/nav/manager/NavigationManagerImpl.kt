package pl.gungnir.challengify.utils.nav.manager

import kotlinx.coroutines.flow.MutableStateFlow
import pl.gungnir.challengify.utils.nav.destination.NavigationCommand
import pl.gungnir.challengify.utils.nav.destination.NavigationDirection
import javax.inject.Inject

class NavigationManagerImpl @Inject constructor() : NavigationManager {

    override val commands = MutableStateFlow(NavigationDirection.started)

    override fun navigate(direction: NavigationCommand) {
        commands.value = direction
    }
}