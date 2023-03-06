package com.example.a20230304_dv_nycschools.data.data.network

import com.example.a20230304_dv_nycschools.data.data.model.SchoolDataModel
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel
import retrofit2.Response
import retrofit2.http.GET

interface SchoolApiClient {

    @GET("s3k6-pzi2.json")
    suspend fun getAllSchools(): Response <List<SchoolModel>>

    @GET("f9bf-2cp4.json")
    suspend fun getAllSchoolsData(): Response <List<SchoolDataModel>>
}