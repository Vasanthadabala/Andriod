package com.example.littlelemon

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.data.Categories

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecialCard()
        LazyRow()
        {
            items(Categories)
            {
                category->
                MenuCategory(category)
            }
        }
        LazyColumn {
            items(dishes) { dish ->
                MenuDish(dish)
            }
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(R.string.weekly_special),
            fontWeight=FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
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


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    Card(onClick = {
        Log.d("AAA", "Click ${dish.id}")
        navController?.navigate(DishDetails.route + "/${dish.id}")
    }) {
        //TODO: Insert code here
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
    )
}
