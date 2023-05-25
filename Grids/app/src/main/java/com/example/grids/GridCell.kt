package com.example.grids

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@Composable
fun MenuGrid(){
    Column(modifier= Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Card(
            elevation =CardDefaults.cardElevation(5.dp),
            modifier = Modifier.padding(5.dp),
            colors =CardDefaults.cardColors(containerColor = Color.LightGray))
        {
            RowScroll()
        }
        ColumnScroll()

    }
}
@ExperimentalMaterial3Api
@Composable
fun ColumnScroll()
{
    Column(Modifier.verticalScroll(rememberScrollState())) {
        repeat(10)
        {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(2)
                {
                    GridCell()
                }
            }
        }
    }
}
@ExperimentalMaterial3Api
@Composable
fun RowScroll(){
    Row(
        Modifier
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        repeat(10)
        {
            GridCell()
    }
}
}

@ExperimentalMaterial3Api
@Composable
fun GridCell()
{
    Card(
        elevation=CardDefaults.cardElevation(10.dp),
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(Color.Cyan)
    ){
        Box(modifier = Modifier
            .requiredSize(180.dp, 180.dp)
            .padding(8.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.greeksalad) ,
                contentDescription ="Greek Salad", Modifier.size(200.dp,140.dp))
            Text(text = "Greek Salad", fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .background(Color.White)
                .align(Alignment.TopStart))
            Text(
                text = "12.99", fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}