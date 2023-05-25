package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}
@ExperimentalMaterial3Api
@Composable
fun HomeScreen()
{
    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent={ DrawerPannel(scaffoldState = scaffoldState, scope = scope)},
        topBar = {
            TopAppBar(scaffoldState=scaffoldState,scope=scope)
            }
        ) {
                    Column(modifier = Modifier.
                    padding(paddingValues = it)
                    )
                    {
                        UpperPanel()
                        LowerPanel()
                    }
            }
}
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview()
{
    HomeScreen()
}

