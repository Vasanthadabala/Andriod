package com.example.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha

@Composable
fun ValueAnimationScreen()
{
    var alfaImage by remember {
        mutableStateOf(0f)
    }
    val animateAlfaImage by animateFloatAsState(targetValue = alfaImage,
        animationSpec = tween(4000))
    Box(modifier = Modifier.fillMaxSize().clickable {alfaImage+=1f}) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Outside Frame",
            modifier = Modifier.align(Alignment.Center))
        Image(painter = painterResource(id = R.drawable.lemon),
            contentDescription ="Lemon",
            modifier = Modifier.align(Alignment.Center).alpha(alpha = animateAlfaImage))
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewScreen()
{
    ValueAnimationScreen()
}
