package com.example.a20230304_dv_nycschools.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230304_dv_nycschools.data.data.model.SchoolDataModel
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel
import com.example.a20230304_dv_nycschools.domain.GetSchoolsDataScores
import com.example.a20230304_dv_nycschools.domain.GetSchoolsList
import kotlinx.coroutines.launch

class NYCSchoolsViewModel : ViewModel() {

    private val _schoolModelList = MutableLiveData<List<SchoolModel>>()
    val schoolModelList : LiveData<List<SchoolModel>> get() = _schoolModelList

    private val _schoolDataModel = MutableLiveData<List<SchoolDataModel>>()
    val schoolDataModel : LiveData<List<SchoolDataModel>> get() = _schoolDataModel

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> get() = _isLoading

    val getSchoolsList = GetSchoolsList()
    val getSchoolsDataScores = GetSchoolsDataScores()

    fun getSchools() {

        viewModelScope.launch {
            try {
                _isLoading.postValue(true)
                val result = getSchoolsList.getListOfSchools()

                if (!result.isNullOrEmpty()) {
                    result.let {
                        _schoolModelList.postValue(it)
                        _isLoading.postValue(false)
                    }
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                println("Error Loading")
            }
        }
    }

    fun getSchoolsData() {

        viewModelScope.launch {
            try {
                val dataResult = getSchoolsDataScores.getSchoolsData()

                if (!dataResult.isNullOrEmpty()) {
                    dataResult.let {
                        _schoolDataModel.postValue(it)
                    }
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                println("Error Loading")
            }
        }
    }
}