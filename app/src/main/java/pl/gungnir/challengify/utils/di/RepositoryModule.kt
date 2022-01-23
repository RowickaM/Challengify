package pl.gungnir.challengify.utils.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.gungnir.challengify.data.repository.EventRepositoryImpl
import pl.gungnir.challengify.domain.repository.EventRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideEventRepository(): EventRepository = EventRepositoryImpl()
}