package com.rafsan.search_android.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import com.rafsan.search_android.activity.MainViewModel
import java.nio.file.WatchEvent


@Composable
fun searchPage(navController: NavController, viewModel: MainViewModel) {

    Scaffold(backgroundColor = Color.White) {
        
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp)) {
            searchBar()

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(viewModel.data) { item ->
                 // Text(text = "Sample item ${item}")
                }
            }
            
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun searchBar() {
    var searchText by remember { mutableStateOf(TextFieldValue(""))}
    val keyboardController = LocalSoftwareKeyboardController.current


    Box(Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background( color = Color(0xffEAF0EC), shape = RoundedCornerShape(20.dp))) {
        TextField(
            value = searchText,
            placeholder = {Text(text = "Search: (eg: Android)", fontSize = 15.sp)},
            onValueChange = {
                searchText = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .background(Color.Transparent)
                .padding(start = 5.dp, end = 5.dp),
            textStyle = TextStyle(
                fontSize = 15.sp,
            ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )

        )

        Row(modifier = Modifier.align(Alignment.CenterEnd)) {

            Box(modifier = Modifier
                .background(Color(0xffDAE3DD), shape = RoundedCornerShape(100))
                .size(40.dp)) {
                Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.Black, modifier = Modifier.size(25.dp).align(
                    Alignment.Center))
            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(modifier = Modifier
                .background(Color(0xffDAE3DD), shape = RoundedCornerShape(100))
                .size(40.dp)) {
                Icon(Icons.Filled.FilterList, contentDescription = "Search", tint = Color.Black, modifier = Modifier.size(23.dp).align(
                    Alignment.Center))
            }

            Spacer(modifier = Modifier.width(10.dp))
        }


    }

    
}



