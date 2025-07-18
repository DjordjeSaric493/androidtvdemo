package com.example.androidtvdemo.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Surface
import androidx.tv.material3.Text

@Composable

fun HomeScreen(){
    Surface (modifier = Modifier.fillMaxSize()){

        Column(modifier= Modifier.fillMaxSize()){
            Column(modifier = Modifier.padding(32.dp)) {
                Text("AndroidTV demo app")
                //kasnije dodajem ui elemente, cards itd itb
            }
        }
    }
}