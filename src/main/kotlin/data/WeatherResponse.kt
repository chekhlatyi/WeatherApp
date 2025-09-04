package data

data class WeatherResponse(
    val location: LocationDto,
    val forecast: ForecastDto)