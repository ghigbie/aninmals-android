package com.traiingtrack.animals.viewmodel

import androidx.lifecycle.MutableLiveData
import com.traiingtrack.animals.model.Animal

class ListViewModel {
    val animals by lazy { MutableLiveData<List<Animal>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val Laoding by lazy { MutableLiveData<Boolean>() }

    fun refresh(){

    }

    private fun getAnimals() {

    }
}