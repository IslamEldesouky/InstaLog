package com.robusta.instalog.domain.entity
import Coordinates
import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

 data class CurrentDayForecast(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    @SerializedName("coord")
    @Embedded
    val coordinates: Coordinates? = null,

    @SerializedName("main")
    @Embedded
    val temp: Temperature? = null,

    @SerializedName("name")
    val locationName: String? = null,

    @SerializedName("sys")
    @Embedded
    val countryInfo: CountryInfo? = null,

    @SerializedName("weather")
    val weather: List<Weather>? = null,

    @SerializedName("wind")
    @Embedded
    val wind: Wind? = null,
)