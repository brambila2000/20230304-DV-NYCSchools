package com.example.a20230304_dv_nycschools.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}