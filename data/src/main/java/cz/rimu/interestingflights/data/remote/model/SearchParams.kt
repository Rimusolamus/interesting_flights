package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class SearchParams(

    @field:Json(name = "flyFrom_type") var flyFromType: String? = null,
    @field:Json(name = "to_type") var toType: String? = null,
    @field:Json(name = "seats") var seats: Seats? = Seats()

)