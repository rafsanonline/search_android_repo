package com.rafsan.search_android.data.local_db

import android.content.Context
import android.view.Display
import androidx.lifecycle.asLiveData
import androidx.paging.PagingSource
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
class GithubDatabaseTest : TestCase() {

    private lateinit var db : GithubDatabase
    private lateinit var dao : GitHubDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context.applicationContext, GithubDatabase::class.java).build()
        dao = db.githubDao()
    }

    @After
    fun closeDB() {
        db.close()
    }

    @Test
    fun insertAndGetData() = runBlocking {
        val data = GithubData().apply {
            id = 1
            name = "Test Name"
            fullName = "Test Full Name"
            avatar = "https://i.picsum.photos/id/356/200/200.jpg?hmac=Pd7TXMbO4gSTwhtmub1DcSo1vPpeCVRsuY_BRE_llmU"
            description = "Test Description"
            createdAt = "2022-06-26T03:41:15Z"
            stars = "000123"

        }
        val repoList = arrayListOf(data)
        dao.insertRepos(repoList)

        var testData = dao.repoList().take(1).toList()[0]
        assertThat(repoList.size == testData.size).isTrue()
    }

}



