package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Route(

    @Json(name = "id") var id: String? = null,
    @Json(name = "combination_id") var combinationId: String? = null,
    @Json(name = "flyFrom") var flyFrom: String? = null,
    @Json(name = "flyTo") var flyTo: String? = null,
    @Json(name = "cityFrom") var cityFrom: String? = null,
    @Json(name = "cityCodeFrom") var cityCodeFrom: String? = null,
    @Json(name = "cityTo") var cityTo: String? = null,
    @Json(name = "cityCodeTo") var cityCodeTo: String? = null,
    @Json(name = "dTime") var dTime: Int? = null,
    @Json(name = "dTimeUTC") var dTimeUTC: Int? = null,
    @Json(name = "aTime") var aTime: Int? = null,
    @Json(name = "aTimeUTC") var aTimeUTC: Int? = null,
    @Json(name = "airline") var airline: String? = null,
    @Json(name = "flight_no") var flightNo: Int? = null,
    @Json(name = "operating_carrier") var operatingCarrier: String? = null,
    @Json(name = "operating_flight_no") var operatingFlightNo: String? = null,
    @Json(name = "fare_basis") var fareBasis: String? = null,
    @Json(name = "fare_category") var fareCategory: String? = null,
    @Json(name = "fare_classes") var fareClasses: String? = null,
    @Json(name = "fare_family") var fareFamily: String? = null,
    @Json(name = "return") var returnFlight: Int? = null,
    @Json(name = "latFrom") var latFrom: Double? = null,
    @Json(name = "lngFrom") var lngFrom: Double? = null,
    @Json(name = "latTo") var latTo: Double? = null,
    @Json(name = "lngTo") var lngTo: Double? = null,
    @Json(name = "mapIdfrom") var mapIdfrom: String? = null,
    @Json(name = "mapIdto") var mapIdto: String? = null,
    @Json(name = "bags_recheck_required") var bagsRecheckRequired: Boolean? = null,
    @Json(name = "vi_connection") var viConnection: Boolean? = null,
    @Json(name = "guarantee") var guarantee: Boolean? = null,
    @Json(name = "equipment") var equipment: String? = null,
    @Json(name = "vehicle_type") var vehicleType: String? = null,
    @Json(name = "original_return") var originalReturn: Int? = null

)