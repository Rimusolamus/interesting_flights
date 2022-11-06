package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class SearchParams(

    @Json(name = "flyFrom_type") var flyFromType: String? = null,
    @Json(name = "to_type") var toType: String? = null,
    @Json(name = "seats") var seats: Seats? = Seats()

)