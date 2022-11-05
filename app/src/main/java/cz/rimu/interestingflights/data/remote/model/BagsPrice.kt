package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class BagsPrice(

    @Json(name = "hand") var hand: Int? = null

)