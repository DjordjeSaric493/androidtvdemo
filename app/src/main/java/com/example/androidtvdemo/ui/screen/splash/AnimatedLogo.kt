package com.example.androidtvdemo.ui.screen.splash
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.Text
import  com.example.androidtvdemo.ui.component.icons.Music_note
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AnimatedLogo() {
    var scale by remember { mutableStateOf(0.8f) }

    // Animacija skale (pumpanje)
    val scaleAnim by animateFloatAsState(
        targetValue = scale,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "scale"
    )

    // Animacija boje teksta
    val infiniteTransition = rememberInfiniteTransition(label = "color")
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color.Magenta,
        targetValue = Color.Cyan,
        animationSpec = infiniteRepeatable(
            animation = tween(1800),
            repeatMode = RepeatMode.Reverse
        ), label = "textColor"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.scale(scaleAnim)
    ) {
        Icon(
            imageVector = Music_note,
            contentDescription = "Muzička nota",
            tint = animatedColor,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "MUZIČKI KVIZ",
            fontSize = 32.sp,
            color = animatedColor,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color.Black,
                    offset= Offset(4f,4f),
                    blurRadius = 8f
                )
            )
        )
    }
}
