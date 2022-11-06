package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Hashtags (

  @field:Json(name="count" ) var count : Int?    = null,
  @field:Json(name="name"  ) var name  : String? = null

)