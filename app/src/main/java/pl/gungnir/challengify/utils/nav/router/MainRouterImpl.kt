package pl.gungnir.challengify.utils.nav.router

import pl.gungnir.challengify.utils.nav.manager.NavigationManager
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigationManager: NavigationManager
) : MainRouter