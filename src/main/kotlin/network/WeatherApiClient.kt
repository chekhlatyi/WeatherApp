package network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
    private val client = OkHttpClient.Builder().build()

    val api: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}
    // WeatherAPI free plan doesn’t support bulk requests.
    // But if it did, or if we will have Pro+, Business or Enterprise plan, then
    // the API call can be changed for Bulk (so we could get all the locations
    // forecasts in a single API call).

    // It can be done by sending request with q=bulk query and passing all the locations in POST's body:

    // curl --location --request POST 'http://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=bulk' \
    //--header 'Content-Type: application/json' \
    //--data '{
    //    "locations": [
    //        {
    //            "q": "Kyiv",
    //            "custom_id": "kyiv"
    //        },
    //        {
    //            "q": "Amsterdam",
    //            "custom_id": "amsterdam"
    //        },
    //        {
    //            "q": "Madrid",
    //            "custom_id": "madrid"
    //        },
    //        {
    //            "q": "Chisinau",
    //            "custom_id": "chisinau"
    //        }
    //    ]
    //}'
