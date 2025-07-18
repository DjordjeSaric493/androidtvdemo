package com.example.androidtvdemo

import androidx.compose.runtime.Composable
import com.example.androidtvdemo.ui.screen.home.HomeScreen
import com.example.androidtvdemo.ui.theme.AndroidTVDemoTheme

@Composable
fun AndroidTVDemoApp(){
    AndroidTVDemoTheme {
        HomeScreen()
    }
}