package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class AirportsList(

    @Json(name = "filterName") var filterName: String? = null,
    @Json(name = "name") var name: String? = null

)