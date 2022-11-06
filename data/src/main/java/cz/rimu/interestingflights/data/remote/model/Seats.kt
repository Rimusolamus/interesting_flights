package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Seats(

    @field:Json(name = "passengers") var passengers: Int? = null,
    @field:Json(name = "adults") var adults: Int? = null,
    @field:Json(name = "children") var children: Int? = null,
    @field:Json(name = "infants") var infants: Int? = null

)