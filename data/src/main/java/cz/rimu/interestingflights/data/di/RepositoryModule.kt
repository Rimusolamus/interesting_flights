package cz.rimu.interestingflights.data.di

import cz.rimu.interestingflights.data.local.datasource.ViewedFlightsLocalDataSource
import cz.rimu.interestingflights.data.remote.datasource.FlightsRemoteDataSourceImpl
import cz.rimu.interestingflights.data.remote.service.ApiService
import cz.rimu.interestingflights.data.repository.FlightsRepositoryImpl
import cz.rimu.interestingflights.domain.repository.FlightsRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideFlightsRemoteDataSource(apiService: ApiService): FlightsRemoteDataSourceImpl {
        return FlightsRemoteDataSourceImpl(apiService)
    }

    @Provides
    fun provideFlightsRepository(
        remoteDataSource: FlightsRemoteDataSourceImpl,
        viewedFlightsLocalDataSource: ViewedFlightsLocalDataSource
    ): FlightsRepository {
        return FlightsRepositoryImpl(
            remoteDataSource,
            viewedFlightsLocalDataSource
        )
    }

}
