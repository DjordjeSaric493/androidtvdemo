package com.example.androidtvdemo.ui.screen.splash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: ()-> Unit){
    var scale by remember { mutableStateOf(0f) }


    val scaleAnimat = animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(
            durationMillis = 800,
            easing = FastOutSlowInEasing
        ), label = "Animacija scale"
    )

    LaunchedEffect(Unit) {
        println("🎬 Splash started")
        scale=1f
        delay(3000)
        println("🎬 splash fin redir to home")
        onSplashFinished()
    }
    //UI u jedan box
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center //poravnanje centralno

    ){
        AnimatedLogo()


    }
}