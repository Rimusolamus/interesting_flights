package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class FlightData(

    @Json(name = "search_id") var searchId: List<Flight>,
    @Json(name = "currency") var currency: String? = null,
    @Json(name = "fx_rate") var fxRate: Int? = null,
    @Json(name = "data") val flight: List<Flight> = arrayListOf(),
    @Json(name = "_results") var Results: Int? = null,
    @Json(name = "best_results") var bestResults: List<String> = arrayListOf(),
    @Json(name = "search_params") var searchParams: SearchParams? = SearchParams(),
    @Json(name = "hashtags") var hashtags: List<Hashtags> = arrayListOf(),
    @Json(name = "location_hashtags") var locationHashtags: List<String> = arrayListOf(),
    @Json(name = "airportsList") var airportsList: List<AirportsList> = arrayListOf(),
    @Json(name = "all_airlines") var allAirlines: List<String> = arrayListOf(),
    @Json(name = "all_stopover_airports") var allStopoverAirports: List<String> = arrayListOf(),
    @Json(name = "all_stopover_countries") var allStopoverCountries: List<String> = arrayListOf(),
    @Json(name = "sort_version") var sortVersion: Int? = null

)