package network

import data.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("key") key: String,                  // API key
        @Query("q") city: String,                   // City name
        @Query("days") days: Int = 2,               // Days to get forecast for (1 - today, 2 - tomorrow)
        @Query("aqi") aqi: String = "no",           // Enable Air quality data
        @Query("alerts") alerts: String = "no"      // Enable Alerts
    ): WeatherResponseDto
}