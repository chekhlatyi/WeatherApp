package data

data class WeatherInfo(
    val city: String,
    val minTemp: Double,
    val maxTemp: Double,
    val humidity: Double,
    val windSpeed: Double,
    val windDirection: String
)
