package cz.rimu.interestingflights.data.di

import android.content.Context
import androidx.room.Room
import cz.rimu.interestingflights.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    private const val DATABASE_NAME = "interestingFlights"

    @Singleton
    @Provides
    fun provideRoomInstance(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideViewedFlightsDao(db: AppDatabase) = db.viewedFlightsDao()
}