package com.robusta.instalog.domain.entity

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("feels_like")
    val feelsLike: Double? = null,

    @SerializedName("humidity")
    val humidity: Int? = null,

    @SerializedName("temp")
    val temp: Double? = null,

    @SerializedName("temp_max")
    val tempMax: Double? = null,

    @SerializedName("temp_min")
    val tempMin: Double? = null
)