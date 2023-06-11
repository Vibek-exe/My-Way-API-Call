package com.example.androidinterntask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidinterntask.model.TaskData
import com.example.androidinterntask.repository.TaskRepository

class TaskViewModel() : ViewModel() {

    private val repository = TaskRepository()
    var showProgress: LiveData<Boolean>
    var errorMessage: LiveData<String>
    var taskDataResponse: LiveData<TaskData>

    init {
        this.showProgress = repository.showProgress
        this.errorMessage = repository.errorMessage
        this.taskDataResponse = repository.taskDataResponse
    }

    fun callTaskApi() {
        repository.getData()
    }

}