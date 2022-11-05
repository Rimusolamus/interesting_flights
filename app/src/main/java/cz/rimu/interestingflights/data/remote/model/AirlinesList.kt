package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class AirlinesList(

    @Json(name = "filterName") var filterName: String? = null

)