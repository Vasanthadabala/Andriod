package com.example.connectingsharedpreferences

import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import com.example.connectingsharedpreferences.ui.theme.ConnectingSharedPreferencesTheme

class MainActivity : ComponentActivity() {
    private val sharedPreferences by lazy {
        getSharedPreferences("Litllelemon", MODE_PRIVATE) //lazy preference reference
    }
    private val showLunchMenuLiveData=MutableLiveData<Boolean>()
    //to store values from sharedPreferences
    private val sharedPreferencesListener = OnSharedPreferenceChangeListener{ sharedPreferences, key->
        if(key=="Lunch Menu")
        {
            showLunchMenuLiveData.value=sharedPreferences.getBoolean(key,false)
        }
    }
    //to observe value changes in SharedPreference and newly obtained value to showLunchMenuLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLunchMenuLiveData.value=sharedPreferences.getBoolean("Lunch Menu",false)
        //When Activity Created title Should update to do that read boolean value from preferences
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)
        //register shared preference listener defined earlier
        setContent {
            ConnectingSharedPreferencesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        val selected=showLunchMenuLiveData.observeAsState(false)
                        //observe showlunchmenu data as state
                        Switch(checked = selected.value, onCheckedChange = {
                            sharedPreferences.edit(commit=true){
                                putBoolean("Lunch Menu",it)
                            }
                            //Adding Switch to presist the switch state
                        })
                        Title(showLunchMenu = selected.value)
                    }
                }
            }
        }
    }
}

@Composable
fun Title(showLunchMenu:Boolean)
{
    val text=if(showLunchMenu)
    {
        "Lunch Menu"
    }
    else
    {
        "BreakFast Menu"
    }
}