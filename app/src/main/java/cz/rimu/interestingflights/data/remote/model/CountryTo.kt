package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class CountryTo (

  @Json(name="code" ) var code : String? = null,
  @Json(name="name" ) var name : String? = null

)