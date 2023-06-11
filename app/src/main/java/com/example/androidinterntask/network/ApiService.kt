package com.example.androidinterntask.network

import com.example.androidinterntask.model.TaskData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/dashboardNew")
    fun getTaskData(): Call<TaskData>

}