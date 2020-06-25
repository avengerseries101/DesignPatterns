package com.example.mvpsampleapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @get:GET("posts")
    val posts : Call<List<PostModel?>?>?

    companion object {
        const val BASE_URL: String = "https://jsonplaceholder.typicode.com"
    }
}