package com.example.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VisibilityScreen()
{
    var visible by remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        AnimatedVisibility(
            visible = visible,
            //enter= fadeIn(animationSpec = tween(2000))
            //,exit = fadeOut(animationSpec = tween(2000))
        )
        {
            Text(text = "Hello", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp))
            
        }
        Button(onClick = { visible= !visible }) {
            Text("Button")
        }
        
    }
}