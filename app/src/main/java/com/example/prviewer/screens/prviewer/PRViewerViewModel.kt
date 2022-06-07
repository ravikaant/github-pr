package com.example.prviewer.screens.prviewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prviewer.model.PRModel
import com.example.prviewer.repository.PRRepository
import kotlinx.coroutines.launch

class PRViewerViewModel(
    private val prRepository: PRRepository)
    : ViewModel() {

    init {
        viewModelScope.launch { getPullRequest() }
    }

    private val prMutableLiveData = MutableLiveData<List<PRModel>>();
    private lateinit var isLoadingLiveData: MutableLiveData<Boolean>
    val prLiveData : LiveData<List<PRModel>>
        get() = prMutableLiveData


    fun isLoading(): LiveData<Boolean> {
        if (!::isLoadingLiveData.isInitialized) {
            isLoadingLiveData = MutableLiveData()
            isLoadingLiveData.value = true
        }
        return isLoadingLiveData
    }



    suspend fun getPullRequest(){
        val pullRequests = prRepository.getPullRequests();
        prMutableLiveData.value = pullRequests!!
        isLoadingLiveData.value=false
    }
}