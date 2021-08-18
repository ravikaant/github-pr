package com.example.prviewer.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prviewer.R
import com.example.prviewer.constant

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
    }

}