package com.rafsan.search_android.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafsan.search_android.data.network.IApiService
import com.rafsan.search_android.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    var mainRepository: MainRepository,
    var apiService: IApiService
):  ViewModel() {

    var data = arrayListOf<String>("1","2","3","4","","","","","")


    init {
        viewModelScope.launch {

        }
    }

}