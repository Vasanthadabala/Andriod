package com.example.higherorderfunction

import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleUI { clickCount->// clickCount saved in Unit Accessed here
                Toast.makeText(this,
                    "Button Clicked $clickCount",Toast.LENGTH_LONG).show()
            }
        }
    }
}
@Composable
fun SimpleUI(onClick:(Int)->Unit)//onclick function declared with Unit Means Nothing to return
{
    var count: Int = 0 //varaible deaclared to count clicks
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onClick(count++) },
            modifier = Modifier.fillMaxWidth(0.5f),
            shape = RoundedCornerShape(6.dp)
        ) { //count number increases on every click
            Text(text = "Button")
        }
    }
}