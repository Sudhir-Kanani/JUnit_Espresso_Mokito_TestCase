package com.testcase.prectice.Api

import com.testcase.prectice.Api.Model.Result

sealed  class MyResponse(val data1 : List<Result>? = null, val exception1: Exception? = null) {
    data object Loading : MyResponse()
    data class  Success(val data : List<Result>?) : MyResponse(data1 = data)
    data class  Error(val exception: Exception?) : MyResponse(exception1 = exception)
}