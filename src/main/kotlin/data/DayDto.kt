package data

import com.google.gson.annotations.SerializedName

data class DayDto (
    @SerializedName("maxtemp_c") val maxTempC: Double,
    @SerializedName("mintemp_c") val minTempC: Double,
    @SerializedName("avghumidity") val avgHumidity: Double,
    @SerializedName("maxwind_kph") val maxWindKph: Double
)