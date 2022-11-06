package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Route(

    @field:Json(name = "id") var id: String? = null,
    @field:Json(name = "combination_id") var combinationId: String? = null,
    @field:Json(name = "flyFrom") var flyFrom: String? = null,
    @field:Json(name = "flyTo") var flyTo: String? = null,
    @field:Json(name = "cityFrom") var cityFrom: String? = null,
    @field:Json(name = "cityCodeFrom") var cityCodeFrom: String? = null,
    @field:Json(name = "cityTo") var cityTo: String? = null,
    @field:Json(name = "cityCodeTo") var cityCodeTo: String? = null,
    @field:Json(name = "dTime") var dTime: Int? = null,
    @field:Json(name = "dTimeUTC") var dTimeUTC: Int? = null,
    @field:Json(name = "aTime") var aTime: Int? = null,
    @field:Json(name = "aTimeUTC") var aTimeUTC: Int? = null,
    @field:Json(name = "airline") var airline: String? = null,
    @field:Json(name = "flight_no") var flightNo: Int? = null,
    @field:Json(name = "operating_carrier") var operatingCarrier: String? = null,
    @field:Json(name = "operating_flight_no") var operatingFlightNo: String? = null,
    @field:Json(name = "fare_basis") var fareBasis: String? = null,
    @field:Json(name = "fare_category") var fareCategory: String? = null,
    @field:Json(name = "fare_classes") var fareClasses: String? = null,
    @field:Json(name = "fare_family") var fareFamily: String? = null,
    @field:Json(name = "return") var returnFlight: Int? = null,
    @field:Json(name = "latFrom") var latFrom: Double? = null,
    @field:Json(name = "lngFrom") var lngFrom: Double? = null,
    @field:Json(name = "latTo") var latTo: Double? = null,
    @field:Json(name = "lngTo") var lngTo: Double? = null,
    @field:Json(name = "mapIdfrom") var mapIdfrom: String? = null,
    @field:Json(name = "mapIdto") var mapIdto: String? = null,
    @field:Json(name = "bags_recheck_required") var bagsRecheckRequired: Boolean? = null,
    @field:Json(name = "vi_connection") var viConnection: Boolean? = null,
    @field:Json(name = "guarantee") var guarantee: Boolean? = null,
    @field:Json(name = "equipment") var equipment: String? = null,
    @field:Json(name = "vehicle_type") var vehicleType: String? = null,
    @field:Json(name = "original_return") var originalReturn: Int? = null

)