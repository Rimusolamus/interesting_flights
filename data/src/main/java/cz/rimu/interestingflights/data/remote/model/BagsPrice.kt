package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class BagsPrice(

    @field:Json(name = "hand") var hand: Float? = null

)