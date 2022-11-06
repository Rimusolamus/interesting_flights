package cz.rimu.interestingflights.data.remote.model

import com.squareup.moshi.Json

data class CountryTo (

  @field:Json(name="code" ) var code : String? = null,
  @field:Json(name="name" ) var name : String? = null

)