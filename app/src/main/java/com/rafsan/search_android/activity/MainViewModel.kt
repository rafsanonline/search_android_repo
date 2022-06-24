package com.rafsan.search_android.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import com.rafsan.search_android.data.network.IApiService
import com.rafsan.search_android.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalPagingApi
@HiltViewModel
class MainViewModel @Inject constructor(
    var mainRepository: MainRepository,
    var apiService: IApiService
):  ViewModel() {


    init {
        viewModelScope.launch {

        }
    }

}