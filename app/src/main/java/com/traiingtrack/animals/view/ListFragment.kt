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
import androidx.recyclerview.widget.ListAdapter

import com.traiingtrack.animals.R
import com.traiingtrack.animals.model.Animal
import com.traiingtrack.animals.view.AnimalListAdapater
import com.traiingtrack.animals.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val listAdapater = AnimalListAdapater(arrayListOf())

    private val animalListDataObserver = Observer<List<Animal>> {list ->
        list?.let {
            animalList.visibility = View.VISIBLE
            listAdapater.updateAnimalList(it)
        }
    }

    private val loadingLiveDataObserver = Observer<Boolean>{isLoading ->
        loadingView.visibility = if(isLoading) View.VISIBLE else View.GONE
        if(isLoading){
            animalList.visibility = View.GONE
            listError.visibility = View.GONE
        }
    }
    
    private val errorLiveDataObserver = Observer<Boolean> {isError ->
        listError.visibility = if(isError) View.VISIBLE else View.GONE
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
        viewModel.animals.observe(this.viewLifecycleOwner, animalListDataObserver)
        viewModel.loading.observe(this.viewLifecycleOwner, loadingLiveDataObserver)
        viewModel.loadError.observe(this.viewLifecycleOwner, errorLiveDataObserver)
        viewModel.refresh()

        animalList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = listAdapater
        }

        refreshLayout.setOnRefreshListener {
            animalList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
    }





}
