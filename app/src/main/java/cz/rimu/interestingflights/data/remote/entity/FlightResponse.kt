package cz.rimu.interestingflights.data.remote.entity

import com.squareup.moshi.Json

data class FlightResponse(

    @field:Json(name = "data")
    val flights: List<FlightItem>? = null,

    @field:Json(name = "sort_version")
    val sortVersion: Int? = null,

    @field:Json(name = "search_id")
    val searchId: String? = null,

    @field:Json(name = "currency")
    val currency: String? = null,

    @field:Json(name = "fx_rate")
    val fxRate: Int? = null
)


data class RouteItem(

    @field:Json(name = "fare_classes")
    val fareClasses: String? = null,

    @field:Json(name = "latFrom")
    val latFrom: Double? = null,

    @field:Json(name = "mapIdto")
    val mapIdto: String? = null,

    @field:Json(name = "bags_recheck_required")
    val bagsRecheckRequired: Boolean? = null,

    @field:Json(name = "guarantee")
    val guarantee: Boolean? = null,

    @field:Json(name = "cityFrom")
    val cityFrom: String? = null,

    @field:Json(name = "operating_carrier")
    val operatingCarrier: String? = null,

    @field:Json(name = "lngFrom")
    val lngFrom: Double? = null,

    @field:Json(name = "dTimeUTC")
    val dTimeUTC: Int? = null,

    @field:Json(name = "vi_connection")
    val viConnection: Boolean? = null,

    @field:Json(name = "aTimeUTC")
    val aTimeUTC: Int? = null,

    @field:Json(name = "fare_category")
    val fareCategory: String? = null,

    @field:Json(name = "flight_no")
    val flightNo: Int? = null,

    @field:Json(name = "fare_basis")
    val fareBasis: String? = null,

    @field:Json(name = "id")
    val id: String? = null,

    @field:Json(name = "airline")
    val airline: String? = null,

    @field:Json(name = "flyTo")
    val flyTo: String? = null,

    @field:Json(name = "fare_family")
    val fareFamily: String? = null,

    @field:Json(name = "cityCodeTo")
    val cityCodeTo: String? = null,

    @field:Json(name = "latTo")
    val latTo: Double? = null,

    @field:Json(name = "lngTo")
    val lngTo: Double? = null,

    @field:Json(name = "combination_id")
    val combinationId: String? = null,

    @field:Json(name = "equipment")
    val equipment: Any? = null,

    @field:Json(name = "vehicle_type")
    val vehicleType: String? = null,

    @field:Json(name = "cityTo")
    val cityTo: String? = null,

    @field:Json(name = "flyFrom")
    val flyFrom: String? = null,

    @field:Json(name = "aTime")
    val aTime: Int? = null,

    @field:Json(name = "mapIdfrom")
    val mapIdfrom: String? = null,

    @field:Json(name = "cityCodeFrom")
    val cityCodeFrom: String? = null,

    @field:Json(name = "dTime")
    val dTime: Int? = null,

    @field:Json(name = "operating_flight_no")
    val operatingFlightNo: String? = null,

    @field:Json(name = "original_return")
    val originalReturn: Int? = null,

    @field:Json(name = "return")
    val jsonMemberReturn: Int? = null,

    @field:Json(name = "following_airport_change")
    val followingAirportChange: Boolean? = null
)

data class Baglimit(

    @field:Json(name = "hand_length")
    val handLength: Int? = null,

    @field:Json(name = "personal_item_weight")
    val personalItemWeight: Int? = null,

    @field:Json(name = "hold_dimensions_sum")
    val holdDimensionsSum: Int? = null,

    @field:Json(name = "hold_width")
    val holdWidth: Int? = null,

    @field:Json(name = "hold_weight")
    val holdWeight: Int? = null,

    @field:Json(name = "hand_weight")
    val handWeight: Int? = null,

    @field:Json(name = "personal_item_length")
    val personalItemLength: Int? = null,

    @field:Json(name = "hand_height")
    val handHeight: Int? = null,

    @field:Json(name = "hold_length")
    val holdLength: Int? = null,

    @field:Json(name = "personal_item_height")
    val personalItemHeight: Int? = null,

    @field:Json(name = "hand_width")
    val handWidth: Int? = null,

    @field:Json(name = "hold_height")
    val holdHeight: Int? = null,

    @field:Json(name = "personal_item_width")
    val personalItemWidth: Int? = null
)

data class BagsPrice(

    @field:Json(name = "1")
    val jsonMember1: Float? = null,

    @field:Json(name = "2")
    val jsonMember2: Float? = null,

    @field:Json(name = "personal_item")
    val personalItem: Int? = null,

    @field:Json(name = "hand")
    val hand: Double? = null
)

data class Availability(

    @field:Json(name = "seats")
    val seats: Int? = null
)

data class Conversion(

    @field:Json(name = "EUR")
    val eUR: Int? = null
)

data class FlightItem(

    @field:Json(name = "fly_duration")
    val flyDuration: String? = null,

    @field:Json(name = "distance")
    val distance: Double? = null,

    @field:Json(name = "hashtags")
    val hashtags: List<String?>? = null,

    @field:Json(name = "tracking_pixel")
    val trackingPixel: String? = null,

    @field:Json(name = "mapIdto")
    val mapIdto: String? = null,

    @field:Json(name = "cityFrom")
    val cityFrom: String? = null,

    @field:Json(name = "availability")
    val availability: Availability? = null,

    @field:Json(name = "has_airport_change")
    val hasAirportChange: Boolean? = null,

    @field:Json(name = "dTimeUTC")
    val dTimeUTC: Int? = null,

    @field:Json(name = "aTimeUTC")
    val aTimeUTC: Int? = null,

    @field:Json(name = "duration")
    val duration: Duration? = null,

    @field:Json(name = "nightsInDest")
    val nightsInDest: Any? = null,

    @field:Json(name = "price")
    val price: Double? = null,

    @field:Json(name = "countryFrom")
    val countryFrom: CountryFrom? = null,

    @field:Json(name = "popularity")
    val popularity: Int? = null,

    @field:Json(name = "airlines")
    val airlines: List<String?>? = null,

    @field:Json(name = "id")
    val id: String? = null,

    @field:Json(name = "flyTo")
    val flyTo: String? = null,

    @field:Json(name = "deep_link")
    val deepLink: String? = null,

    @field:Json(name = "conversion")
    val conversion: Conversion? = null,

    @field:Json(name = "cityCodeTo")
    val cityCodeTo: String? = null,

    @field:Json(name = "booking_token")
    val bookingToken: String? = null,

    @field:Json(name = "baglimit")
    val baglimit: Baglimit? = null,

    @field:Json(name = "cityTo")
    val cityTo: String? = null,

    @field:Json(name = "flyFrom")
    val flyFrom: String? = null,

    @field:Json(name = "countryTo")
    val countryTo: CountryTo? = null,

    @field:Json(name = "quality")
    val quality: Double? = null,

    @field:Json(name = "aTime")
    val aTime: Long? = null,

    @field:Json(name = "facilitated_booking_available")
    val facilitatedBookingAvailable: Boolean? = null,

    @field:Json(name = "route")
    val route: List<RouteItem?>? = null,

    @field:Json(name = "mapIdfrom")
    val mapIdfrom: String? = null,

    @field:Json(name = "cityCodeFrom")
    val cityCodeFrom: String? = null,

    @field:Json(name = "technical_stops")
    val technicalStops: Int? = null,

    @field:Json(name = "bags_price")
    val bagsPrice: BagsPrice? = null,

    @field:Json(name = "dTime")
    val dTime: Long? = null,

    @field:Json(name = "virtual_interlining")
    val virtualInterlining: Boolean? = null,

    @field:Json(name = "throw_away_ticketing")
    val throwAwayTicketing: Boolean? = null,

    @field:Json(name = "hidden_city_ticketing")
    val hiddenCityTicketing: Boolean? = null,

    @field:Json(name = "pnr_count")
    val pnrCount: Int? = null
)

data class Duration(

    @field:Json(name = "total")
    val total: Int? = null,

    @field:Json(name = "departure")
    val departure: Int? = null,

    @field:Json(name = "return")
    val jsonMemberReturn: Int? = null
)

data class CountryTo(

    @field:Json(name = "code")
    val code: String? = null,

    @field:Json(name = "name")
    val name: String? = null
)

data class CountryFrom(

    @field:Json(name = "code")
    val code: String? = null,

    @field:Json(name = "name")
    val name: String? = null
)
