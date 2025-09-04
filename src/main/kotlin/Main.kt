import network.WeatherApiClient
import service.WeatherService
import utils.TableFormatter

fun main() {
    // Adding an API key to repo is a bad idea, but for the sake of simplicity I'll leave it here
    // Alternatively you can add this key to env or to some config. For example:
    // val apiKey = System.getenv("WEATHER_API_KEY") ?: error("Set WEATHER_API_KEY environment variable first!")

    val apiKey = "5f4414955a064236acc65730250409"

    val service = WeatherService(apiKey)
    val cities = listOf("Chisinau", "Madrid", "Kyiv", "Amsterdam")

    val weatherData = service.getWeatherForCities(cities)

    TableFormatter.printWeatherTable(weatherData)
}
