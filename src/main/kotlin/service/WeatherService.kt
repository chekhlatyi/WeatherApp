package service

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import data.WeatherResponseDto
import data.WeatherInfo

class WeatherService(private val apiKey: String) {

    fun getWeatherForCities(cities: List<String>): List<WeatherInfo> = runBlocking {
        coroutineScope {
            val deferred = cities.map { city ->
                async {
                    try {
                        val response: WeatherResponseDto = network.WeatherApiClient.api.getForecast(
                            apiKey, city
                        )
                        val forecastDay = response.forecast.forecastday[1] // next day
                        val day = forecastDay.day
                        // pick the hour with max wind speed
                        val windDir = forecastDay.hour.maxByOrNull { it.wind_kph }?.wind_dir ?: "N/A"

                        WeatherInfo(
                            city = response.location.name,
                            minTemp = day.minTempC,
                            maxTemp = day.maxTempC,
                            humidity = day.avgHumidity,
                            windSpeed = day.maxWindKph,
                            windDirection = windDir
                        )
                    } catch (e: Exception) {
                        println("Failed to fetch data for $city: ${e.message}")
                        null
                    }
                }
            }
            deferred.awaitAll().filterNotNull()
        }
    }
}