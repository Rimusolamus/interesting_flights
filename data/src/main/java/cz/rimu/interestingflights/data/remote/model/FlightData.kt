package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class FlightData(

    @field:Json(name = "search_id") var searchId: String,
    @field:Json(name = "currency") var currency: String? = null,
    @field:Json(name = "fx_rate") var fxRate: Int? = null,
    @field:Json(name = "data") val flight: List<Flight> = arrayListOf(),
    @field:Json(name = "_results") var Results: Int? = null,
    @field:Json(name = "best_results") var bestResults: List<String> = arrayListOf(),
    @field:Json(name = "search_params") var searchParams: SearchParams? = SearchParams(),
    @field:Json(name = "hashtags") var hashtags: List<Hashtags> = arrayListOf(),
    @field:Json(name = "location_hashtags") var locationHashtags: List<String> = arrayListOf(),
    @field:Json(name = "airportsList") var airportsList: List<AirportsList> = arrayListOf(),
    @field:Json(name = "all_airlines") var allAirlines: List<String> = arrayListOf(),
    @field:Json(name = "all_stopover_airports") var allStopoverAirports: List<String> = arrayListOf(),
    @field:Json(name = "all_stopover_countries") var allStopoverCountries: List<String> = arrayListOf(),
    @field:Json(name = "sort_version") var sortVersion: Int? = null

)