package com.example.androidtvdemo.ui.component.cards

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api:: class)
@Composable
fun MenuCard(
    title: String,
    onClick:()->Unit = {}
){
  //opis, modifier,oblik, boja
    Card(
        onClick=onClick,
        modifier = Modifier
            .size(width = 300.dp,
                height = 185.dp)
            .focusable(),
        shape = CardDefaults.shape(RoundedCornerShape(18.dp)),
        colors = CardDefaults.colors(
            contentColor = Color(0xFF1A1A1A),
            focusedContentColor = Color(0xFF8800FF)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontSize = 22.sp,
                color = Color.White
            )
        }
    }
}