package com.example.androidtvdemo.ui.component.animations


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text

//can't spell title without "tit"...

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AnimatedTitle(
    text: String,
    modifier: Modifier= Modifier
){   //spisak boja. munuću u drugi fajl
    val neonColors = listOf(
        Color(0xFFFF00FF), // neon pink
        Color(0xFF00FFFF), // neon cyan
        Color(0xFFFFFF00), // neon yellow
        Color(0xFFFF9900), // neon orange
        Color(0xFF00FF00), // neon green
        Color(0xFF9900FF), // neon purple
        Color(0xFF00FF99), // teal green
        Color(0xFFFF0066), // hot pink
        Color(0xFF33FFFF), // bright aqua
        Color(0xFFFF3300)  // neon red
    )

    var colorIndex by remember { mutableStateOf(0) }
    //ciklična promena boje

    LaunchedEffect(Unit){
        while(true){
            colorIndex= (colorIndex+1)% neonColors.size
            kotlinx.coroutines.delay(1000) //promena na svaki sekund
        }
    }
 //prelazak u sledeću boju
    val animatedColor by animateColorAsState(
        targetValue = neonColors[colorIndex],
        animationSpec = tween(durationMillis = 1000)
    )
    //pulse efekat, pesma Pulse od Archive jebedeete btw
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000,
                easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse),
        label = "scaleAnimation"
    )
    Text(
        text = text,
        fontSize = 28.sp,
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .padding(bottom = 18.dp),
        textAlign = TextAlign.Center,
        color = animatedColor
    )

}