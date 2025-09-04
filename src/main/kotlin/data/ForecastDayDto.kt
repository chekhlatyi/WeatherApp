package data

data class ForecastDayDto(
    val date: String,
    val day: DayDto,
    val hour: List<HourDto>
)