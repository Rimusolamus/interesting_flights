package cz.rimu.interestingflights.data.remote.datasource

import cz.rimu.interestingflights.data.constant.NetworkStatus
import cz.rimu.interestingflights.data.remote.model.FlightData
import cz.rimu.interestingflights.data.remote.service.ApiService
import cz.rimu.interestingflights.data.util.safeApiCall

class FlightsRemoteDataSourceImpl(private val apiService: ApiService) {
    suspend fun getFlights(startDate: String, endDate: String): NetworkStatus<FlightData> =
        safeApiCall { apiService.getFlights(dateFrom = startDate, dateTo = endDate) }
}