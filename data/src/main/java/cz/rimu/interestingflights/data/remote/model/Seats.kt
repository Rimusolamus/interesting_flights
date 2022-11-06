package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Seats(

    @Json(name = "passengers") var passengers: Int? = null,
    @Json(name = "adults") var adults: Int? = null,
    @Json(name = "children") var children: Int? = null,
    @Json(name = "infants") var infants: Int? = null

)