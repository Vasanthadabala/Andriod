package com.example.lazygrid

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VerticalGrid()
{
    LazyVerticalGrid(columns = GridCells.Fixed(3) )
    {
        items(60)
        {
            number->MyGridCell(number)
        }
    }
}
@Composable
fun VerticalGrid2()
{
    LazyVerticalGrid(columns = GridCells.Adaptive(140.dp))
    {
        items(100)
        {
                number->MyGridCell(number)
        }
    }
}
@Composable
fun MyGridCell(number:Int)
{
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(15.dp)) {
        Box(
            modifier = Modifier.aspectRatio(1f),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Item" + number,
                fontSize = 20.sp)
        }

    }
}