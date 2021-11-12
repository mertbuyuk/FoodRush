package com.mb.fooddelivery.di

import android.content.Context
import com.mb.fooddelivery.model.local.LocalDataSource
import com.mb.fooddelivery.model.local.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityRetainedComponent::class)
class LocalModule {


    @Provides
    fun sharedPref(@ApplicationContext context: Context): SharedPref {
        return SharedPref(context)
    }

    @Provides
    fun localDataSource(sharedPref: SharedPref) : LocalDataSource{
        return LocalDataSource(sharedPref)
    }
}