package com.example.kotlinpractice.drawerprac.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }


    private val _textnew= MutableLiveData<String>()
    init {
        _textnew.value = "This is slideshow Fragment new"
    }

    val text: LiveData<String> = _text
}