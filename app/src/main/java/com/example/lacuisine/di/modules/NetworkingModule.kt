package com.example.lacuisine.di.modules

import com.example.lacuisine.networking.RecipesAPI
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

const val loggingInterceptorKey = "loggingInterceptor"
const val apiKeyInterceptorKey = "apiKeyInterceptor"

@Module
class NetworkingModule {
    private val baseURL = "https://api.spoonacular.com/"
    private val defaultTimeout: Long = 15
    private val apiKey = "apiKey"
    private val apiKeyValue = "db04885d89af449a82222a4a547773f0"

    @Singleton
    @Provides
    @Named(loggingInterceptorKey)
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    @Named(apiKeyInterceptorKey)
    fun provideAPIKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val url = request.url.newBuilder().addQueryParameter(apiKey, apiKeyValue).build()
            chain.proceed(request.newBuilder().url(url).build())
        }
    }
    @Singleton
    @Provides
    fun providesOkHttpClient(
        @Named(loggingInterceptorKey) apiLoggingInterceptor: Interceptor,
        @Named(apiKeyInterceptorKey) apiKeyInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(defaultTimeout, TimeUnit.SECONDS)
            .readTimeout(defaultTimeout, TimeUnit.SECONDS)
            .addInterceptor(apiLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .build()
    }
    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesRecipesAPI(retrofit: Retrofit) : RecipesAPI {
        return retrofit.create(RecipesAPI::class.java)
    }
}