package com.example.retrofitassessment


import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST

interface ItemsService {
    @GET("items")
    suspend fun getALLItems(): List<Items>

    @POST("students")
    suspend fun addStudent(@Body post: Student): List<Student>
}
