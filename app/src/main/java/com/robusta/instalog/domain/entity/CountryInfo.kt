package com.robusta.instalog.domain.entity

import com.google.gson.annotations.SerializedName

data class CountryInfo(
    @SerializedName("country")
    val name: String? = null
)
