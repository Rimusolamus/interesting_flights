package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Conversion(

    @Json(name = "EUR") var EUR: Int? = null

)