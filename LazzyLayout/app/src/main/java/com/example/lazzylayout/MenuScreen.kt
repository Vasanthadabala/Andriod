package com.example.lazzylayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazzylayout.data.Categories
import com.example.lazzylayout.data.Dish
import com.example.lazzylayout.data.dishes

@Composable
fun MenuList()
{
    Column {
        LazyRow()
        {
            items(Categories)
            {
                category->
                MenuCategory(category)
            }
        }
        Divider(
            modifier=Modifier.padding(8.dp),
            color = Color.Gray,
        thickness = 1.dp
        )
        LazyColumn()
        {
            items(dishes)
            {
                dish->
                MenuDish(dish)
            }
        }
    }
}

@Composable
fun MenuCategory(category:String)
{
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.Gray),
        shape = RoundedCornerShape(25),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(text = category)
    }
}
@Composable
fun MenuDish(dish:Dish)
{
    Card(
        elevation = CardDefaults.cardElevation(50.dp),modifier = Modifier.padding(5.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            Column {
                Text(text = dish.name, fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = dish.description,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f))
                Text(
                    text = dish.price,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top=5.dp)
                )
            }
            Image(painter = painterResource(id = dish.image),
                contentDescription ="" )
        }
        
    }
}