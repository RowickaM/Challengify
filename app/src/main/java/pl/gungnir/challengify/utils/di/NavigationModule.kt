package pl.gungnir.challengify.utils.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.gungnir.challengify.utils.nav.manager.NavigationManager
import pl.gungnir.challengify.utils.nav.manager.NavigationManagerImpl
import pl.gungnir.challengify.utils.nav.router.MainRouter
import pl.gungnir.challengify.utils.nav.router.MainRouterImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideNavigationManager(navigationManagerImpl: NavigationManagerImpl): NavigationManager

    @Binds
    abstract fun provideMainRouter(mainRouterImpl: MainRouterImpl): MainRouter

}