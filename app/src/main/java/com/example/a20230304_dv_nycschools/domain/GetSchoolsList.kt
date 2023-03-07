package com.example.a20230304_dv_nycschools.domain

import com.example.a20230304_dv_nycschools.data.data.SchoolRepository
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel

class GetSchoolsList {
    private val repository = SchoolRepository()
    suspend fun getListOfSchools() : List<SchoolModel>? = repository.getAllSchools()
}