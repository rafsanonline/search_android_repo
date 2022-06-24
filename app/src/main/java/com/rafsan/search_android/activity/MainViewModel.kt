package com.rafsan.search_android.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.withTransaction
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rafsan.search_android.data.local_db.GithubData
import com.rafsan.search_android.data.local_db.GithubDatabase
import com.rafsan.search_android.data.model.GithubSearchData
import com.rafsan.search_android.data.network.IApiService
import com.rafsan.search_android.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    var mainRepository: MainRepository,
    var database: GithubDatabase,
):  ViewModel() {

    var hashMap : HashMap<String, String> =  HashMap()
    var data = mutableListOf<GithubData>()

    fun apiSearchRepo(searchByDate: Boolean, searchByStar: Boolean) =
        viewModelScope.launch {
            if (searchByDate) {
                hashMap["sort"] = "updated_at"
                hashMap["direction"] = "desec"
            } else if (searchByStar) {
                hashMap["sort"] = "stargazers_count"
                hashMap["direction"] = "desec"
            }
            hashMap["q"] = "Android"
            hashMap["per_page"] = "1"
            hashMap["page"] = "1"

            try {
                mainRepository.apiRepositories(hashMap).let {
                    val type = object : TypeToken<GithubSearchData>() {}.type
                    val result = Gson().fromJson<GithubSearchData>(
                            it.body()?.string(), type
                        )

                    when(it.code()) {
                        200 -> {
                            result.items?.forEachIndexed { index, item ->
                                val repo = GithubData()
                                repo.name = item?.name.toString()
                                repo.fullName = item?.fullName.toString()
                                repo.description = item?.description.toString()
                                repo.avatar = item?.owner?.avatarUrl.toString()
                                repo.createdAt = item?.updatedAt.toString()
                                repo.stars = item?.stargazersCount.toString()
                                data.add(repo)
                            }

                            database.withTransaction {
                                database.githubDao().deleteAllRepo()
                                database.githubDao().insertRepos(data)
                            }
                        }
                    }

                 }
            } catch (exception: NullPointerException) {

            }


        }
}