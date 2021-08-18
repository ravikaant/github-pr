package com.example.prviewer.screens.prviewer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prviewer.R
import com.example.prviewer.adapter.PRAdapter
import com.example.prviewer.utils.constant
import com.example.prviewer.network.ApiClient
import com.example.prviewer.repository.PRRepository
import kotlinx.android.synthetic.main.p_r_viewer_fragment.*

class PRViewerFragment : Fragment() {

    private lateinit var viewModel: PRViewerViewModel
    private lateinit var prViewModelFactory: PRViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.p_r_viewer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel(){
        val prRepository = PRRepository(ApiClient.getInstance(), constant.CLOSED)

        prViewModelFactory = PRViewModelFactory(prRepository)
        viewModel = ViewModelProvider(this,prViewModelFactory).get(PRViewerViewModel::class.java,)

        viewModel.prLiveData.observe(viewLifecycleOwner, Observer {prModel ->
            recycler_view.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = PRAdapter(prModel)
//                val itemDecoration=DividerItemDecoration(recycler_view.context,
//                    LinearLayoutManager(requireContext()).orientation)
//                it.addItemDecoration(itemDecoration)
            }

        })
    }




}