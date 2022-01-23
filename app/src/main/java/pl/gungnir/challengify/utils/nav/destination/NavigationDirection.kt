package pl.gungnir.challengify.utils.nav.destination

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object NavigationDirection {

    val KEY_EVENT_ID = "eventId"
    val KEY_USER_ID = "userId"
    val eventDetailsDestination = "events/{$KEY_EVENT_ID}"
    val eventRankDestination = "events/{$KEY_EVENT_ID}/rank"
    val userDetailsDestination = "users/{$KEY_USER_ID}"

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

    val eventsList = object : NavigationCommand {
        override val destination = "events"
        override val arguments = emptyList<NamedNavArgument>()
    }

    val createEvent = object : NavigationCommand {
        override val destination = "createEvent"
        override val arguments = emptyList<NamedNavArgument>()
    }

    fun eventDetails(eventId: String) = object : NavigationCommand {
        override val destination = "events/{$eventId}"
        override val arguments = listOf(
            navArgument(KEY_EVENT_ID) { type = NavType.StringType }
        )
    }

    fun eventRank(eventId: String) = object : NavigationCommand {
        override val destination = "events/{$eventId}/rank"
        override val arguments = listOf(
            navArgument(KEY_EVENT_ID) { type = NavType.StringType }
        )
    }

    fun userDetails(userId: String) = object : NavigationCommand {
        override val destination = "users/{$userId}"
        override val arguments = listOf(
            navArgument(KEY_USER_ID) { type = NavType.StringType }
        )
    }
}