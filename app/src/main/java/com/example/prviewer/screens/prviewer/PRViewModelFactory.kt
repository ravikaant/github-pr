package com.example.prviewer.screens.prviewer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prviewer.repository.PRRepository

class PRViewModelFactory (
         private val prRepository: PRRepository)

    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PRViewerViewModel(prRepository) as T
    }
}