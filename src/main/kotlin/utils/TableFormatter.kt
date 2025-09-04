package utils

import data.WeatherInfo

object TableFormatter {
    fun printWeatherTable(data: List<WeatherInfo>) {
        val header = "| %-12s | %-10s | %-10s | %-10s | %-12s | %-13s |".format(
            "City", "Min Temp (C)", "Max Temp (C)", "Humidity (%)", "Wind Speed (km/h)", "Wind Dir"
        )
        val separator = "-".repeat(header.length)
        println(separator)
        println(header)
        println(separator)
        data.forEach {
            println(
                "| %-12s | %-12.1f | %-12.1f | %-12.1f | %-17.1f | %-13s |".format(
                    it.city, it.minTemp, it.maxTemp, it.humidity, it.windSpeed, it.windDirection
                )
            )
        }
        println(separator)
    }
}