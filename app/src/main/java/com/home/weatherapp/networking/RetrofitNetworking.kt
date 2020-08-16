package com.home.weatherapp.networking

import android.text.TextUtils
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

object RetrofitNetworking {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        Timber.e(baseUrl)
        if (retrofit == null || !TextUtils.isEmpty(baseUrl)) {
            //TODO While release in Google Play Change the Level to NONE
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)//EncryptDecryptInterceptor() --Encrypted Data Decrypt
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())//GsonConverter
                .addCallAdapterFactory(CoroutineCallAdapterFactory())//Coroutines-Jake warthon
                .build()
        } else {
            Timber.e("Retrofit is not null || BaseUrl is null")
        }


        return retrofit

    }
}