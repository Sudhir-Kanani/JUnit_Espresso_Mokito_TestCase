package com.testcase.prectice.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testcase.prectice.Api.MyResponse
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {


    private  var newsLiveData  = MutableLiveData<MyResponse>()

    val newsData : LiveData<MyResponse>
        get() = newsLiveData

    fun getNews() {
        viewModelScope.launch {
           val result =  repository.callApi()
            newsLiveData.postValue(result)
        }
    }

}