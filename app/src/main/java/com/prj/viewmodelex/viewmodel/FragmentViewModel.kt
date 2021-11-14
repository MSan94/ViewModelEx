package com.prj.viewmodelex.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

class FragmentViewModel(application: Application) : AndroidViewModel(application) {
    var fragmentText : ObservableField<String> = ObservableField("")
    val mApplication = application

    fun onPress(){
        Toast.makeText(mApplication,"눌려짐",Toast.LENGTH_SHORT).show()
        fragmentText.set("hello")
    }

}