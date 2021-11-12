package com.mb.fooddelivery.di

import com.mb.fooddelivery.model.local.LocalDataSource
import com.mb.fooddelivery.model.remote.FoodApiService
import com.mb.fooddelivery.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule{

    @AuthRetrofit
    @Provides
    fun provideRetrofit(
        authClient: AuthOkHttpClient,
    ) : Retrofit=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(authClient.okHttpClient)
            .build()

    @Provides
    fun provideApiService(@AuthRetrofit retrofit: Retrofit) : FoodApiService{
        return retrofit.create(FoodApiService::class.java)
    }

    @Provides
    fun provideAuthInterceptorOkHttpClient(
        localDataSource: LocalDataSource
    ): AuthOkHttpClient {
        return provideAuthOkHttpClient(
            OkHttpClient.Builder()
                /*.addInterceptor {
                 add token
                }*/
                .build())
    }

    private fun provideAuthOkHttpClient(authClient: OkHttpClient): AuthOkHttpClient {
        return AuthOkHttpClient(authClient)
    }
}

data class AuthOkHttpClient(val okHttpClient: OkHttpClient)

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthRetrofit
