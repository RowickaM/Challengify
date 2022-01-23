package pl.gungnir.challengify.utils.nav.manager

import kotlinx.coroutines.flow.MutableStateFlow
import pl.gungnir.challengify.utils.nav.destination.NavigationCommand

interface NavigationManager {

    val commands: MutableStateFlow<NavigationCommand>

    fun navigate(direction: NavigationCommand)
}