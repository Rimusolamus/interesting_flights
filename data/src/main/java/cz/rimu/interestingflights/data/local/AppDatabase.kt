package cz.rimu.interestingflights.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.rimu.interestingflights.data.local.dao.ViewedFlightsDao
import cz.rimu.interestingflights.domain.model.FlightDomain

@Database(
    entities = [FlightDomain.FlightDomainItem::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun viewedFlightsDao(): ViewedFlightsDao
}
