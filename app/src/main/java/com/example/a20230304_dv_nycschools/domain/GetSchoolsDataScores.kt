package com.example.a20230304_dv_nycschools.domain

import com.example.a20230304_dv_nycschools.data.data.SchoolRepository
import com.example.a20230304_dv_nycschools.data.data.model.SchoolDataModel

class GetSchoolsDataScores {
    private val repository = SchoolRepository()
    suspend fun getSchoolsData() : List<SchoolDataModel>? = repository.getAllSchoolsData()
}