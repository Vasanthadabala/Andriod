package com.example.lazzylayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun Basic()
{
    Column {
        LazyRowRememberedState()
        LazyColumnRemberedState()
    }
}

@Composable
fun LazyRowRememberedState() {
    LazyRow(state = rememberLazyListState()) {
        items(50) {
            MyCard(number = it)
        }
    }
}
@Composable
fun LazyColumnRemberedState()
{
    LazyColumn(state= rememberLazyListState())
    {
        items(50)
        {
            MyCard(number = it)
        }
    }
}
@Composable
fun MyCard(number:Int) {
    Card(
    elevation = CardDefaults.cardElevation(16.dp),
    modifier = Modifier.padding(16.dp)
    )  {
        Text(
            text = number.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
            )
    }
}
