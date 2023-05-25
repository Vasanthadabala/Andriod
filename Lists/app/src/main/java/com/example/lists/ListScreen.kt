package com.example.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen()
{
    Row(modifier= Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Categories.forEach{
            MenuCategory(category = it)
        }
    }
}
@Composable
fun MenuCategory(category:String)
{
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
    shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp))
    {
        Text(text = category)
    }
}
val Categories= listOf<String>(
    "Launch",
    "Dessert",
    "Mains",
    "Menu"
)