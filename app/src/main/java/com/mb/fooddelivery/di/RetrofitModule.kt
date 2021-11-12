package com.mb.fooddelivery.di

import com.google.gson.Gson
import com.mb.fooddelivery.BuildConfig
import com.mb.fooddelivery.model.local.LocalDataSource
import com.mb.fooddelivery.model.remote.AuthApiService
import com.mb.fooddelivery.model.remote.AuthDataSource
import com.mb.fooddelivery.model.remote.FoodApiService
import com.mb.fooddelivery.model.remote.RemoteDataSource
import com.mb.fooddelivery.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule{

    @Provides
    fun provideApiService(@NoAuthRetrofit retrofit: Retrofit): FoodApiService {
        return retrofit.create(FoodApiService::class.java)
    }

    @Provides
    fun provideAuthApiService(@AuthRetrofit retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    @NoAuthRetrofit
    fun provideRetrofit(
        noAuthOkHttpClient: NoAuthOkHttpClient,
        gson: Gson,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(noAuthOkHttpClient.okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): NoAuthOkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return provideNoAuthOkHttpClient(builder.build())
    }

    @Provides
    @AuthRetrofit
    fun provideAuthRetrofit(
        authOkHttpClient: AuthOkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(authOkHttpClient.okHttpClient)
            .build()
    }


    @Provides
    fun provideAuthInterceptorOkHttpClient(
        localDataSource: LocalDataSource
    ): AuthOkHttpClient {
        return provideAuthOkHttpClient(OkHttpClient.Builder()
            .addInterceptor {
                val token = localDataSource.getToken()
                val request = it.request().newBuilder().addHeader("Authorization", token!!).build()
                it.proceed(request)
            }
            .build())
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideRemoteDataSource(
        apiService: FoodApiService,
    ): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

    @Provides
    fun provideAuthRemoteDataSource(
        authAPIService: AuthApiService,
    ): AuthDataSource {
        return AuthDataSource(authAPIService)
    }

    private fun provideAuthOkHttpClient(okHttpClient: OkHttpClient): AuthOkHttpClient {
        return AuthOkHttpClient(okHttpClient)
    }

    private fun provideNoAuthOkHttpClient(okHttpClient: OkHttpClient): NoAuthOkHttpClient {
        return NoAuthOkHttpClient(okHttpClient)
    }
}

data class AuthOkHttpClient(val okHttpClient: OkHttpClient)

data class NoAuthOkHttpClient(val okHttpClient: OkHttpClient)

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoAuthRetrofit