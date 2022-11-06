package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Flight(

    val id: String? = null,
    val flyFrom: String? = null,
    val flyTo: String? = null,
    val cityFrom: String? = null,
    val cityCodeFrom: String? = null,
    val cityTo: String? = null,
    val cityCodeTo: String? = null,
    val countryFrom: Country? = null,
    val countryTo: Country? = null,
    val dTime: Long? = null,
    val dTimeUTC: Long? = null,
    val aTime: Long? = null,
    val aTimeUTC: Long? = null,
    val nightsInDest: Any? = null,
    val quality: Double? = null,
    val popularity: Long? = null,
    val distance: Double? = null,

    @field:Json(name = "fly_duration") val flyDuration: String,

    val price: Long? = null,
    val conversion: Conversion? = null,

    @field:Json(name = "bags_price") val bagsPrice: BagsPrice,

    val baglimit: Map<String, Long>? = null,
    val availability: Availability? = null,
    val airlines: List<String>? = null,
    val route: List<Route>? = null,

    @field:Json(name = "booking_token") val bookingToken: String,

    @field:Json(name = "deep_link") val deepLink: String,

    @field:Json(name = "tracking_pixel") val trackingPixel: String,

    @field:Json(name = "facilitated_booking_available") val facilitatedBookingAvailable: Boolean,

    @field:Json(name = "pnr_count") val pnrCount: Long,

    @field:Json(name = "has_airport_change") val hasAirportChange: Boolean,

    @field:Json(name = "technical_stops") val technicalStops: Long,

    @field:Json(name = "throw_away_ticketing") val throwAwayTicketing: Boolean,

    @field:Json(name = "hidden_city_ticketing") val hiddenCityTicketing: Boolean,

    @field:Json(name = "virtual_interlining") val virtualInterlining: Boolean,

    val mapIdfrom: String? = null,
    val mapIdto: String? = null,
    val hashtags: List<String>? = null

)