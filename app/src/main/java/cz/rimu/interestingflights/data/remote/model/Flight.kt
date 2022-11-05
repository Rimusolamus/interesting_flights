package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Flight(

    val id: String,
    val flyFrom: String,
    val flyTo: String,
    val cityFrom: String,
    val cityCodeFrom: String,
    val cityTo: String,
    val cityCodeTo: String,
    val countryFrom: Country,
    val countryTo: Country,
    val dTime: Long,
    val dTimeUTC: Long,
    val aTime: Long,
    val aTimeUTC: Long,
    val nightsInDest: Any? = null,
    val quality: Double,
    val popularity: Long,
    val distance: Double,
    val duration: Duration,

    @Json(name = "fly_duration")
    val flyDuration: String,

    val price: Long,
    val conversion: Conversion,

    @Json(name = "bags_price")
    val bagsPrice: BagsPrice,

    val baglimit: Map<String, Long>,
    val availability: Availability,
    val airlines: List<String>,
    val route: List<Route>,

    @Json(name = "booking_token")
    val bookingToken: String,

    @Json(name = "deep_link")
    val deepLink: String,

    @Json(name = "tracking_pixel")
    val trackingPixel: String,

    @Json(name = "facilitated_booking_available")
    val facilitatedBookingAvailable: Boolean,

    @Json(name = "pnr_count")
    val pnrCount: Long,

    @Json(name = "has_airport_change")
    val hasAirportChange: Boolean,

    @Json(name = "technical_stops")
    val technicalStops: Long,

    @Json(name = "throw_away_ticketing")
    val throwAwayTicketing: Boolean,

    @Json(name = "hidden_city_ticketing")
    val hiddenCityTicketing: Boolean,

    @Json(name = "virtual_interlining")
    val virtualInterlining: Boolean,

    val mapIdfrom: String,
    val mapIdto: String,
    val hashtags: List<String>

)