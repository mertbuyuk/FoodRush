package com.mb.fooddelivery.model

import com.mb.fooddelivery.model.data.login.LoginRequest
import com.mb.fooddelivery.model.local.LocalDataSource
import com.mb.fooddelivery.model.remote.AuthDataSource
import com.mb.fooddelivery.model.remote.RemoteDataSource
import com.mb.fooddelivery.utils.networkOperation
import com.mb.fooddelivery.utils.networkOperationAuth
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private var authRemoteDataSource: AuthDataSource,
    private var localDataSource: LocalDataSource
) {

    fun login(request: LoginRequest) = networkOperationAuth(
        call = {
            remoteDataSource.loginRequest(request)
        },
        saveToken = {
            localDataSource.saveToken(it)
        }
    )

    fun getRestaurants() = networkOperation(call = {
        authRemoteDataSource.getRestaurants()
    })

    fun getRestaurantMeals(id : Int) = networkOperation(call = {
        authRemoteDataSource.getRestaurantMeals(id)
    })

    fun getMealDetail(id: Int) = networkOperation(call = {
        authRemoteDataSource.getMealDetail(id)
    })

    fun addToCart(id : Int, count : Int) = networkOperation(call = {
        authRemoteDataSource.addToCart(id,count)
    })

    fun getCart() = networkOperation(call = {
        authRemoteDataSource.getCart()
    })
}