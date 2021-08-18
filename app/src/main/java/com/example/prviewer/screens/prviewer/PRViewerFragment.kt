package com.example.prviewer.screens.prviewer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prviewer.R
import com.example.prviewer.adapter.PRAdapter
import com.example.prviewer.utils.constant
import com.example.prviewer.utils.network.ApiClient
import com.example.prviewer.repository.PRRepository
import com.example.prviewer.utils.PrItemClickListener
import kotlinx.android.synthetic.main.p_r_viewer_fragment.*

class PRViewerFragment : Fragment() ,PrItemClickListener{

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
        setupProgressBar()
    }

    private fun setUpViewModel(){
        val prRepository = PRRepository(ApiClient.getInstance(), constant.CLOSED)
        prViewModelFactory = PRViewModelFactory(prRepository)
        viewModel = ViewModelProvider(this,prViewModelFactory).get(PRViewerViewModel::class.java,)

        viewModel.prLiveData.observe(viewLifecycleOwner, Observer {prModel ->
            recycler_view.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = PRAdapter(prModel,this)

            }
        })
    }

    private fun setupProgressBar(){
        viewModel.isLoading().observe(viewLifecycleOwner, Observer {
            it ?.let{
                progress_bar.visibility = if(it) View.VISIBLE else View.GONE
        }
        })
    }


    override fun onItemClick(position: Int) {
        Toast.makeText(this.context,"$position item is clicked",Toast.LENGTH_SHORT).show()
    }
}