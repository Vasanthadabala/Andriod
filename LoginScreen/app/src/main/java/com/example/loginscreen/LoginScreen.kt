package com.example.loginscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun LoginScreen()
{
    val context= LocalContext.current
    var username by remember{ mutableStateOf(TextFieldValue("")) }
    var password by remember{ mutableStateOf(TextFieldValue("")) }
    Column(
        Modifier.fillMaxSize()
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(id = R.drawable.lemon),
            contentDescription = "Logo Image", modifier = Modifier.padding(8.dp))
        TextField(value = username, onValueChange ={username= it},
            label={ Text(text = "Username") },modifier = Modifier.padding(8.dp))
        TextField(value = password, onValueChange ={password= it},
            label={ Text(text = "Password") },modifier = Modifier.padding(8.dp))
        Button(onClick = { if(username.text=="Vasanthadabala"&&password.text=="12345") {
            Toast.makeText(context,"Welcome to Little Lemon", Toast.LENGTH_LONG).show() }
        else
        {
            Toast.makeText(context,"Invalid Credentials."+
                    "Please Try Again.", Toast.LENGTH_LONG).show()
        }
        }
            , colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = Modifier.padding(8.dp),)
        {
            Text(text = "Login")
        }

    }
}