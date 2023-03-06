package com.example.a20230304_dv_nycschools.data.data

import com.example.a20230304_dv_nycschools.data.data.model.SchoolDataModel
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel
import com.example.a20230304_dv_nycschools.data.data.model.SchoolProvider
import com.example.a20230304_dv_nycschools.data.data.network.SchoolService

class SchoolRepository {

    private val api = SchoolService()

    suspend fun getAllSchools() : List<SchoolModel>{
        val response = api.getSchoolList()
        SchoolProvider.schools = response // keeping List in memory like a small database
        return response
    }

    suspend fun getAllSchoolsData() : List<SchoolDataModel>{
        val response = api.getSchoolListScores()
        SchoolProvider.schoolScores = response // keeping List in memory like a small database
        return response
    }
}