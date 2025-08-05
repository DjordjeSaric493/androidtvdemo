package com.example.androidtvdemo.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import androidx.tv.material3.*
import androidx.tv.foundation.lazy.*
import androidx.tv.foundation.lazy.list.TvLazyRow
import com.example.androidtvdemo.ui.component.animations.AnimatedTitle
import com.example.androidtvdemo.ui.component.cards.MenuCard

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(){
    Surface (modifier = Modifier.fillMaxSize()){
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)){
         AnimatedTitle("MUZIČKI KVIZ") //can't spell title without "tit"

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 200.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp),
                horizontalArrangement = Arrangement.spacedBy(22.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item { MenuCard(title = "🎵 Nova igra") }
                item { MenuCard(title = "🏆 Scoreboard") }
                item { MenuCard(title = "📺 Playlist") }
                item { MenuCard(title = "ℹ️ Info") }
            }
        }
    }
}