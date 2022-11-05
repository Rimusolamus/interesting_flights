package cz.rimu.interestingflights.data.remote.service

import cz.rimu.interestingflights.data.remote.entity.FlightResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("flights")
    suspend fun getFlights(
        @Query("v") version: String = "3",
        @Query("sort") sort: String = "popularity",
        @Query("asc") asc: String = "0",
        @Query("locale") locale: String = "en",
        @Query("daysInDestination") daysInDestination: String = "",
        @Query("affilid") affilId: String = "",
        @Query("children") children: String = "0",
        @Query("infants") infants: String = "0",
        @Query("flyFrom") flyFrom: String = "49.2-16.61-250km",
        @Query("to") to: String = "anywhere",
        @Query("featureName") featureName: String = "aggregateResults",
        @Query("dateFrom") dateFrom: String = "06/10/2022",
        @Query("dateTo") dateTo: String = "06/11/2022",
        @Query("typeFlight") typeFlight: String = "oneway",
        @Query("returnFrom") returnFrom: String = "",
        @Query("returnTo") returnTo: String = "",
        @Query("one_per_date") onePerDate: String = "0",
        @Query("oneforcity") oneForCity: String = "1",
        @Query("wait_for_refresh") waitForRefresh: String = "0",
        @Query("adults") adults: String = "1",
        @Query("limit") limit: String = "45",
        @Query("partner") partner: String = "skypicker-android",
    ): Response<FlightResponse>
}
