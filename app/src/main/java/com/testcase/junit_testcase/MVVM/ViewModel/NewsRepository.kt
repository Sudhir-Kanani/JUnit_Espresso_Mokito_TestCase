package com.testcase.prectice.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.testcase.prectice.Api.MyResponse
import com.testcase.prectice.Api.NewsApi

class NewsRepository (private val newsApi: NewsApi) {

    private  var newsLiveData  = MutableLiveData<MyResponse>()


    suspend fun callApi() : MyResponse {
        newsLiveData.postValue(MyResponse.Loading)
        try {
            val result =  newsApi.newsApi("pub_366411336e6ba4de4754e39485ab62b09891a")
            if (result.body() != null){
                newsLiveData.postValue(MyResponse.Success(result.body()?.results))
//                Log.d("callApi : ","results : ${result.body()?.results.toString()}")
                return  MyResponse.Success(result.body()?.results)

            }else
            {
                newsLiveData.postValue(MyResponse.Error(NullPointerException()))
//                Log.d("callApi : ","results : null")
                return  MyResponse.Error(NullPointerException())

            }

        }catch (e:Exception){
            newsLiveData.postValue(MyResponse.Error(e))
//            Log.d("callApi : ","Exception : ${e.toString()}")
            return  MyResponse.Error(e)

        }
    }
}