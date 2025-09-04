package data

data class WeatherResponseDto(
    val location: LocationDto,
    val forecast: ForecastDto
)