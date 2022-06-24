package com.rafsan.search_android.repo

import androidx.paging.ExperimentalPagingApi
import com.rafsan.search_android.data.network.IApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject


@ExperimentalPagingApi
class MainRepository @Inject constructor(
    private val apiService: IApiService,
) {

    companion object {
        const val REPO_PATH = "repositories"
    }

    suspend fun apiRepositories(
        hashMap: HashMap<String, String>,
    ): Response<ResponseBody> {
        return withContext(Dispatchers.IO) {
            apiService.getRequest(REPO_PATH, hashMap = hashMap)
        }
    }

}