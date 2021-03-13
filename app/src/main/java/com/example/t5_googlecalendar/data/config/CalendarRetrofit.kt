package com.example.t5_googlecalendar.data.config

import androidx.databinding.library.BuildConfig
import com.example.t5_googlecalendar.base.util.NetworkManager
import com.example.t5_googlecalendar.base.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class CalendarRetrofit @Inject constructor(private val networkManager: NetworkManager){
    private var authenticationToken: String = "ya29.a0AfH6SMDCIai_ko-Tqdbv-LpU6UZcb-Tz62wpDPyBRUN1KoT3XRP9cdqkniOTGHIryfABUQT5WTzrhIK9wifd67BAPdt5bST2PTM1y1kVmDY1sMcOmHyrpeZpqnXflhNuqTX17aOm2YiQguP1yM9tJkyXBMoUzg"


    fun loadRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/calendar/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()
    }


    private fun createHttpClient(): OkHttpClient {
        // Create OkHttpClient
        val builder = OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)

        // Logger interceptor
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        builder.addInterceptor(loggerInterceptor)

        // Check internet connectivity
        val checkInternetConnectivityInterceptor = Interceptor {
            if(!networkManager.isNetworkAvailable()){
                throw NoInternetException()
            }

            it.proceed(it.request())
        }

        builder.addInterceptor(checkInternetConnectivityInterceptor)

        // App token
        builder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $authenticationToken")
                .build()
            chain.proceed(request)
        }

        return builder.build()
    }
}