package com.example.androidinterntask.repository

import androidx.lifecycle.MutableLiveData
import com.example.androidinterntask.model.TaskData
import com.example.androidinterntask.network.ApiService
import com.example.androidinterntask.retrofit.RetrofitService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskRepository {

    val showProgress = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()
    var taskDataResponse = MutableLiveData<TaskData>()

    fun getData() {

        val client = RetrofitService.getApiData()?.create(ApiService::class.java)
        val call = client?.getTaskData()

        call?.enqueue(object : Callback<TaskData?> {
            override fun onResponse(
                call: Call<TaskData?>,
                response: Response<TaskData?>
            ) {
                showProgress.postValue(false)
                val body = response.body()
                if (response.isSuccessful) {
                    taskDataResponse.postValue(body)

                } else {
                    val jObjError = JSONObject(response.errorBody()?.string())
                    errorMessage.postValue(jObjError.getString("message"))
                }
            }

            override fun onFailure(call: Call<TaskData?>, t: Throwable) {
                showProgress.postValue(false)
                errorMessage.postValue("Server error please try after sometime")

            }
        })


    }

}