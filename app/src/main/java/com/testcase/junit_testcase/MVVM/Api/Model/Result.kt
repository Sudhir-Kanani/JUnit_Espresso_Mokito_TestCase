package com.testcase.prectice.Api.Model

data class Result(
    val ai_tag: String,
    val article_id: String,
    val category: List<String>,
    val content: String,
    val country: List<String>,
    val creator: Any,
    val description: String,
    val image_url: String,
    val keywords: Any,
    val language: String,
    val link: String,
    val pubDate: String,
    val sentiment: String,
    val sentiment_stats: String,
    val source_id: String,
    val source_priority: Int,
    val source_url: String,
    val title: String,
    val video_url: Any
)