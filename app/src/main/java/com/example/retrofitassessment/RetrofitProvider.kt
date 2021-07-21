package com.example.retrofitassessment

import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider { val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://ict-yep-backend.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())

    .build()

    val service: ItemsService = retrofit.create(ItemsService::class.java)




}