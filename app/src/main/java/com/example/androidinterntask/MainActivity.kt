package com.example.androidinterntask

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidinterntask.databinding.ActivityMainBinding
import com.example.androidinterntask.model.TaskData
import com.example.androidinterntask.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var taskData: ArrayList<TaskData>? = null
    private var viewModel: TaskViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)


        callTaskApi()
        observeApiResponse()

    }

    private fun callTaskApi() {
        viewModel?.callTaskApi()
    }

    private fun observeApiResponse() {
        viewModel?.taskDataResponse?.observe(this, Observer {

            Log.e("hello", it.toString())
            binding.hlTv.text = it.data.toString()


        })
    }


}