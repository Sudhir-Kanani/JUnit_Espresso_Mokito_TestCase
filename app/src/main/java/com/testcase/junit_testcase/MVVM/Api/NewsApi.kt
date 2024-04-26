package com.testcase.prectice.Api

import com.testcase.prectice.Api.Model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("news?")
    suspend  fun newsApi(@Query("apiKey") apiKey :String) : Response<NewsModel>
}