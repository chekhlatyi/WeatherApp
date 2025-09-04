package data

data class DayDto (
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val avghumidity: Double,
    val maxwind_kph: Double,
    val condition: ConditionDto,
    val daily_will_it_rain: Int,
    val daily_chance_of_rain: Int,
    val maxwind_dir: String
)