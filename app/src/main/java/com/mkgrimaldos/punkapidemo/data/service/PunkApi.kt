package com.mkgrimaldos.punkapidemo.data.service

import com.mkgrimaldos.punkapidemo.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PunkApi {

    private val BASE_URL = " https://api.punkapi.com/v2/"

    fun createServiceApi(): PunkApiService {
        val retrofit = createRetrofitInstance(BASE_URL)
        return retrofit.create(PunkApiService::class.java)
    }

    private fun createRetrofitInstance(url: String): Retrofit {
        val interceptors = mutableListOf<Interceptor>()
        if (BuildConfig.DEBUG) {
            interceptors.add(createLoggingInterceptor())
        }
        val okHttpClient = createOkHttpClient(interceptors)
        return provideRetrofit(okHttpClient, url)
    }

    private fun provideRetrofit(client: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createOkHttpClient(interceptors: List<Interceptor>): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .readTimeout(70, TimeUnit.SECONDS)
            .connectTimeout(70, TimeUnit.SECONDS)
            .writeTimeout(70, TimeUnit.SECONDS)
        interceptors.forEach {
            builder.addInterceptor(it)
        }
        return builder.build()
    }

    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
            redactHeader("Authorization");
            redactHeader("Cookie");
        }
    }
}