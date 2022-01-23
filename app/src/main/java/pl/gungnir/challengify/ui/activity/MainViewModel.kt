package pl.gungnir.challengify.ui.activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.gungnir.challengify.utils.nav.manager.NavigationManager
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    navigationManager: NavigationManager,
) : ViewModel() {

    val router = navigationManager.commands
}