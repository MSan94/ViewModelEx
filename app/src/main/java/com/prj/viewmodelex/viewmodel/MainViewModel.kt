package com.prj.viewmodelex.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    var mainText : ObservableField<String> = ObservableField("초기값")
//    var mainText  = ObservableField<String>()
    private var _height = MutableLiveData<Int>()
    val height : LiveData<Int>
        get() = _height

    init{
        _height.value = 170
    }

    fun increase(){
        _height.value = _height.value?.plus(1)
    }

    fun changeText(text : String){
        Log.d("TestText","전달받은 값 : $text" )
        mainText.set(text)
    }
}