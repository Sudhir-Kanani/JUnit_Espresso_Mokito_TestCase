package com.testcase.prectice.Api.Model

data class NewsModel(
    val results: List<Result>,
    val status: String,
    val totalResults: Int
)