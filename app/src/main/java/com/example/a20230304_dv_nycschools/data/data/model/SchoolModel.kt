package com.example.a20230304_dv_nycschools.data.data.model

import com.google.gson.annotations.SerializedName

data class SchoolModel (
    @SerializedName ("school_name") val name: String,
){
}