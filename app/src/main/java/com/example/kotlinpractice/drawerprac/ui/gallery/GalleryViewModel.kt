package com.example.kotlinpractice.drawerprac.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value= "This is gallery fragment new new"
    }
    val  text: LiveData<String> = _text

}