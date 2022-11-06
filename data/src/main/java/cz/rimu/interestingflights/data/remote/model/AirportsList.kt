package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class AirportsList(

    @field:Json(name = "filterName") var filterName: String? = null,
    @field:Json(name = "name") var name: String? = null

)