package com.rafsan.search_android.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.rafsan.search_android.pages.searchPage
import com.rafsan.search_android.ui.theme.Search_androidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagingApi::class)
    private val viewModel: MainViewModel by viewModels()


    @OptIn(ExperimentalPagingApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            runApplication(viewModel)
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    @Composable
    private fun runApplication(viewModel: MainViewModel) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "search_page", builder = {
            composable("search_page", content = { searchPage(navController = navController, viewModel = viewModel) })
        })
    }
}
