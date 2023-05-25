package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UpperPanel()
{
    val context= LocalContext.current
Column(
    Modifier
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.olive2)),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.Start) {
    Text(text = stringResource(id = R.string.title),
        fontSize = 40.sp,
        color= Color(0xFFFFFF14),
        modifier = Modifier.padding(start = 10.dp,top=10.dp))
    Text(text = stringResource(id = R.string.chicago),
        fontSize = 24.sp,
        color= colorResource(id = R.color.white),
        modifier = Modifier.padding(start = 10.dp))
    Row(
        Modifier.fillMaxWidth().padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Text(
            text = stringResource(id = R.string.description),
            modifier = Modifier.fillMaxWidth (.6f)
                .padding(start = 10.dp, bottom = 25.dp, end = 20.dp)
            ,color = Color.White)
        Image(painter = painterResource(id = R.drawable.restaurant),
            contentDescription = "Image",
            Modifier.clip(RoundedCornerShape(10.dp)))
    }
    Button(onClick = { Toast.makeText(context,"Order received.Thank you!",
        Toast.LENGTH_SHORT).show()},
        shape = RoundedCornerShape(15.dp),
        colors=ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Text(text = stringResource(id =R.string.order),
            color = colorResource(id = R.color.black), fontWeight = FontWeight.Bold)
    }
}
}