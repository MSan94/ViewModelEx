package com.prj.viewmodelex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.prj.viewmodelex.R
import com.prj.viewmodelex.databinding.FragmentABinding
import com.prj.viewmodelex.viewmodel.FragmentViewModel
import com.prj.viewmodelex.viewmodel.MainViewModel

class Afragment() : Fragment() {
    private lateinit var binding : FragmentABinding
    private lateinit var subViewModel : FragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_a,container,false)
        activity?.let {
            subViewModel = ViewModelProvider(it).get(FragmentViewModel::class.java)
            binding.viewModel = subViewModel
            binding.lifecycleOwner = this
        }
        return binding.root
    }
}