package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Availability(

    @Json(name = "seats") var seats: Int? = null

)