package com.prj.viewmodelex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prj.viewmodelex.databinding.ActivityMainBinding
import com.prj.viewmodelex.fragment.Afragment
import com.prj.viewmodelex.fragment.Bfragment
import com.prj.viewmodelex.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
//    private lateinit var mainViewModel : MainViewModel
    private val mainViewModel : MainViewModel by viewModels() //데이터를 공유할게 아니면 이렇게 가능

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        
        // mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // binding.user = model 데이터를 공유할게 아니면 이렇게 가능

        /** 옵저빙 **/
        mainViewModel.height.observe(this, Observer {
            binding.textViewCount.text = it.toString()
            var count = parseInt(binding.textViewCount.text.toString())
            if(count in 180..189){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentArea, Bfragment())
                    .commit()
            }else if(count >= 190){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentArea, Afragment())
                    .commit()
            }
        })

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentArea , Afragment())
            .commit()
    }
}