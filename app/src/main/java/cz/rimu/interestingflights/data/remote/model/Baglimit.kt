package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Baglimit(

    @Json(name = "hand_height") var handHeight: Int? = null,
    @Json(name = "hand_length") var handLength: Int? = null,
    @Json(name = "hand_weight") var handWeight: Int? = null,
    @Json(name = "hand_width") var handWidth: Int? = null,
    @Json(name = "hold_dimensions_sum") var holdDimensionsSum: Int? = null,
    @Json(name = "hold_height") var holdHeight: Int? = null,
    @Json(name = "hold_length") var holdLength: Int? = null,
    @Json(name = "hold_weight") var holdWeight: Int? = null,
    @Json(name = "hold_width") var holdWidth: Int? = null

)