package com.robusta.instalog.domain.entity

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed")
    val speed: Double? = null
)