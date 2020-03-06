package com.traiingtrack.animals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.traiingtrack.animals.R
import com.traiingtrack.animals.model.Animal
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalListAdapterTwo(private val animalList: ArrayList<Animal>):
    RecyclerView.Adapter<AnimalListAdapterTwo.AnimalViewHolder>() {

    fun upddateAnimalList(newAnimalList: List<Animal>){
        animalList.clear()
        animalList.addAll(newAnimalList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflator: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount() = animalList.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int){
        holder.view.animalName.text = animalList[position].name
    }

    class AnimalViewHolder(var view: View): RecyclerView.ViewHolder(view){}
}