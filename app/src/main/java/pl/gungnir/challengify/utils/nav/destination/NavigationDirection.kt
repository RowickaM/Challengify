package pl.gungnir.challengify.utils.nav.destination

import androidx.navigation.NamedNavArgument

object NavigationDirection {

    val registration = object : NavigationCommand {
        override val destination = "registration"
        override val arguments = emptyList<NamedNavArgument>()
    }

    val login = object : NavigationCommand {
        override val destination = "login"
        override val arguments = emptyList<NamedNavArgument>()
    }

    val started = object : NavigationCommand {
        override val destination = "started"
        override val arguments = emptyList<NamedNavArgument>()
    }
}