package pl.gungnir.challengify.utils.nav.destination

import androidx.navigation.NamedNavArgument

interface NavigationCommand {

    val destination: String
    val arguments: List<NamedNavArgument>
}