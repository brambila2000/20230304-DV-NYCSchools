package com.example.a20230304_dv_nycschools.data.data.model

class SchoolProvider {
   /* companion object {

        fun getSchoolsList(): List<SchoolModel>{
            return schoolList
        }

        private val schoolList = listOf<SchoolModel>(
            SchoolModel("Maranatha School"),
            SchoolModel("Mira Mesa School"),
            SchoolModel("Sorrento Vally School"),
            SchoolModel("Middle School"),
            SchoolModel("San Ysidro School"),
        )
    }*/

    companion object {
        var schools : List<SchoolModel> = emptyList()
        var schoolScores : List<SchoolDataModel> = emptyList()
    }
}