package com.example.a20230304_dv_nycschools.data.data.model

import com.google.gson.annotations.SerializedName

class SchoolDataModel (
    @SerializedName("school_name") val name: String,
    @SerializedName("num_of_sat_test_takers") val takers: String,
    @SerializedName("sat_critical_reading_avg_score") val reading: String,
    @SerializedName("sat_math_avg_score") val math: String,
    @SerializedName("sat_writing_avg_score") val writing: String,
){
}