package com.example.prviewer.screens.prviewer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.prviewer.R
import com.example.prviewer.constant
import com.example.prviewer.model.PRModel
import com.example.prviewer.network.ApiClient
import com.example.prviewer.repository.PRRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class PRViewerFragment : Fragment() {

    private lateinit var viewModel: PRViewerViewModel
    private lateinit var prViewModelFactory: PRViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setUpViewModel()
        return inflater.inflate(R.layout.p_r_viewer_fragment, container, false)
    }


    private fun setUpViewModel(){
        val prRepository = PRRepository(ApiClient.getInstance(),constant.CLOSED)
        prViewModelFactory = PRViewModelFactory(prRepository)
        viewModel = ViewModelProvider(this,prViewModelFactory).get(PRViewerViewModel::class.java,)

        viewModel.prLiveData.observe(viewLifecycleOwner, Observer {
            it?.forEach {
                Log.d("kishanlogs",it.toString())
            }
        })
    }




}