package com.example.a20230304_dv_nycschools.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230304_dv_nycschools.data.data.model.SchoolDataModel
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel
import com.example.a20230304_dv_nycschools.data.data.model.SchoolProvider
import com.example.a20230304_dv_nycschools.domain.GetSchoolsDataScores
import com.example.a20230304_dv_nycschools.domain.GetSchoolsList
import kotlinx.coroutines.launch

class NYCSchoolsViewModel : ViewModel() {

    val schoolModelList = MutableLiveData<List<SchoolModel>>()
    val schoolDataModel = MutableLiveData<List<SchoolDataModel>>()

    val isLoading = MutableLiveData<Boolean>()

    val getSchoolsList = GetSchoolsList()
    val getSchoolsDataScores = GetSchoolsDataScores()

    fun getSchools(){
        try {
            viewModelScope.launch {
                isLoading.postValue(true)
                val result = getSchoolsList.getListOfSchools()
                //val dataResult = getSchoolsDataScores.getSchoolsData()

                if (!result.isNullOrEmpty()) {
                    result?.let {
                        schoolModelList.postValue(it)
                        isLoading.postValue(false)
                    }
                }
                /*if (!dataResult.isNullOrEmpty()) {
                    //result?.let{schoolModelList.postValue(it)
                    dataResult?.let {
                        schoolDataModel.postValue(it)
                        println(it.joinToString(" "))
                    }
                }*/
            }
        }catch(e: java.lang.Exception){
            e.printStackTrace()
            println("Error Loading")
        }
    }

    fun getSchoolsData(){
        try {
            viewModelScope.launch {
                val dataResult = getSchoolsDataScores.getSchoolsData()

                if (!dataResult.isNullOrEmpty()) {
                    //result?.let{schoolModelList.postValue(it)
                    dataResult?.let {
                        schoolDataModel.postValue(it)
                    }
                }
            }
        }catch(e: java.lang.Exception){
            e.printStackTrace()
            println("Error Loading")
        }
    }

    fun getSchoolsList(){
        /*val schoolList : List<SchoolModel> = SchoolProvider.getSchoolsList()
        schoolModelList.value = schoolList*/
    }
}