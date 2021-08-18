package com.example.prviewer.screens.prviewer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    companion object {
        fun newInstance() = PRViewerFragment()
    }

    private lateinit var viewModel: PRViewerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.p_r_viewer_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PRViewerViewModel::class.java)
        // TODO: Use the ViewModel

        GlobalScope.launch(Dispatchers.IO) {
            fetchAllPR()
        }
    }

    suspend fun fetchAllPR(){

        val prRepository : PRRepository = PRRepository(ApiClient.getInstance(),constant.CLOSED);
        val prList : List<PRModel>? = prRepository.getAllClosedPR();

        prList?.forEach {
            Log.d("kishanlogs",it.toString());
        }
    }

}