package com.rafsan.search_android.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafsan.search_android.pages.detailPage
import com.rafsan.search_android.pages.searchPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            runApplication(viewModel)
        }
    }


    @Composable
    private fun runApplication(viewModel: MainViewModel) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "search_page", builder = {
            composable("search_page", content = { searchPage(navController = navController, viewModel = viewModel) })
            composable("details_page", content = { detailPage(navController = navController, viewModel = viewModel) })
        })
    }
}
