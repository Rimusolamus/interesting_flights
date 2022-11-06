package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Duration(

    @Json(name = "departure") var departure: Int? = null,
    @Json(name = "return") var returnFlight: Int? = null,
    @Json(name = "total") var total: Int? = null

)