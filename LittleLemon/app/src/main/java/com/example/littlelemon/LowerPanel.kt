package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LowerPanel()
{
    Column(modifier = Modifier.background(color = Color.White)) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        {
            Text(text = "WeeklySpecial", fontSize = 26.sp, modifier = Modifier.padding(8.dp) ,fontWeight = FontWeight.Bold)
        }
        Card() {
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column() {
                    Text(text ="Greek Salad", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "The famous greek salad of " +"\n" +
                            "crispy lettuce, peppers, olives,"+"\n"+
                            "our Chicago ...", color = Color.Gray, modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f))
                    Text(text = "12.99",fontWeight = FontWeight.Bold,color = Color.Gray)
                }
                Image(painter = painterResource(id = R.drawable.greeksalad), contentDescription ="")
            }
        }
    }
    Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = Color.LightGray,
        thickness = 1.dp)
}
