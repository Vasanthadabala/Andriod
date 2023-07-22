package com.example.sharedpreferences

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sharedpreferences.ui.theme.SharedPreferencesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedPreferencesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    Text(text = "Little Lemon")
                }
            }
        }
    }

    override fun onStart() { //Modifying start activity every app open this activity runs
        super.onStart()
        val sharedPreferences=
            getSharedPreferences("LittleLemon", MODE_PRIVATE)//Declared To store Simple Data
        val lastcount=
            sharedPreferences.getInt("StartCount",0)//Retrieve Startcount if not exits stores Default count value as 0
        val newcount=lastcount+1 //Incremenet value +1 everytime app opens
        Log.d("StartCount","Newcount:$newcount")//Output the new Value We use Log.d
        sharedPreferences.edit().putInt("StartCount",newcount).apply()//StartCount is key and newcount is value to show
    }
}