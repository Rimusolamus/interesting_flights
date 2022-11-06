package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Baglimit(

    @field:Json(name = "hand_height") var handHeight: Int? = null,
    @field:Json(name = "hand_length") var handLength: Int? = null,
    @field:Json(name = "hand_weight") var handWeight: Int? = null,
    @field:Json(name = "hand_width") var handWidth: Int? = null,
    @field:Json(name = "hold_dimensions_sum") var holdDimensionsSum: Int? = null,
    @field:Json(name = "hold_height") var holdHeight: Int? = null,
    @field:Json(name = "hold_length") var holdLength: Int? = null,
    @field:Json(name = "hold_weight") var holdWeight: Int? = null,
    @field:Json(name = "hold_width") var holdWidth: Int? = null

)