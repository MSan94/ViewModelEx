package com.prj.viewmodelex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prj.viewmodelex.databinding.ActivityMainBinding
import com.prj.viewmodelex.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainViewModel : MainViewModel
    //private val model : UserViewModel by viewModels() 데이터를 공유할게 아니면 이렇게 가능

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.user = mainViewModel
        // binding.user = model 데이터를 공유할게 아니면 이렇게 가능

        mainViewModel.height.observe(this, Observer {
            binding.textViewHeight.text = it.toString()
        })

    }
}