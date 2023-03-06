package com.example.a20230304_dv_nycschools.data.data.network

import com.example.a20230304_dv_nycschools.core.RetrofitHelper
import com.example.a20230304_dv_nycschools.data.data.model.SchoolDataModel
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SchoolService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getSchoolList(): List<SchoolModel>{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(SchoolApiClient::class.java).getAllSchools()
            response.body() ?: emptyList()
        }
    }

    suspend fun getSchoolListScores(): List<SchoolDataModel>{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(SchoolApiClient::class.java).getAllSchoolsData()
            response.body() ?: emptyList()
        }
    }
}