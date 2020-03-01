package com.traiingtrack.animals.view.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager

import com.traiingtrack.animals.R
import com.traiingtrack.animals.model.Animal
import com.traiingtrack.animals.view.AnimalListAdapater
import com.traiingtrack.animals.view.ListFragmentDirections
import com.traiingtrack.animals.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val listAdapater = AnimalListAdapater(arrayListOf())
    private val animalListDataObserver = Observer<List<Animal>> {list ->

    }

    private val loadingLiveDataObserver = Observer<Boolean>{isLoading ->

    }
    
    private val errorLiveDataObserver = Observer<Boolean> {isError ->

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.animals.observe(this, animalListDataObserver)
        viewModel.loading.observe(this, loadingLiveDataObserver)
        viewModel.loadError.observe(this, errorLiveDataObserver)
        viewModel.refresh()

        animalList.apply {
            layoutManager = GridLayoutManager(context, 2)
        }
    }



}
