package com.home.weatherapp.networking

import com.home.weatherapp.networking.model.JsonValue
import com.home.weatherapp.networking.responsePojo.dashBoard.ApiResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url
import timber.log.Timber

interface ApiInterface {


    /**********************************todo Api Service's***********************************/
    //@Field parameters can only be used with form encoding (POST)
    //@Query This annotation represents any query key value pair to be sent along with the network request GET/POST
    //@Path parameter name must match \{([a-zA-Z][a-zA-Z0-9_-]*)\}.


    /*todo------((Api1--Get Values))*/
    @POST
    fun getResult(@Url speechUrl: String, @Body jsonValue: JsonValue): Single<Response<ApiResponse>>


    /**Create Retrofit Service--By Calling class Create Retrofit**/
    class CreateRetrofit {
        fun apiService(url: String?): ApiInterface {
            Timber.e("""RetrofitUrl$url""")
            return when (url) {
                WebService.LiveUrl -> {
                    RetrofitNetworking.getClient(WebService.LiveUrl)!!.create(ApiInterface::class.java)
                }
                else -> {
                    Timber.e(url)
                    url?.let { RetrofitNetworking.getClient(it) }!!.create(ApiInterface::class.java)
                }
            }
        }
    }
}