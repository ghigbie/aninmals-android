package com.traiingtrack.animals.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.traiingtrack.animals.model.Animal

class ListViewModel(application: Application): AndroidViewModel(application){
    val animals by lazy { MutableLiveData<List<Animal>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    fun refresh(){
        getAnimals()
    }

    private fun getAnimals() {
        val a1 = Animal("Alligator")
        val a2 = Animal("Badger")
        val a3 = Animal("Coyote")
        val a4 = Animal("Duck")
        val a5 = Animal("Elk")
        val a6 = Animal("Frog")

        val animalList: ArrayList<Animal> = arrayListOf(a1, a2, a3, a4, a5, a6)
        animals.value = animalList
        loadError.value = false
        loading.value = false
    }
}