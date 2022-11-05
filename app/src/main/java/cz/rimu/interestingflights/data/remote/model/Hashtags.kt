package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class Hashtags (

  @Json(name="count" ) var count : Int?    = null,
  @Json(name="name"  ) var name  : String? = null

)