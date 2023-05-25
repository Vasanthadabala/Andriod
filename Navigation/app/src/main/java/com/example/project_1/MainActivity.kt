package com.example.project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigation()
        }
    }
}
@Composable
fun MyNavigation()
{
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination=Home.route)
    {
        composable(Home.route)
        {
            HomeScreen(navController)
        }
        composable(MenuList.route)
        {
            MenuListScreen(navController)
        }
        composable(Dashboard.route)
        {
            DashboardScreen(navController)
        }
        composable(Details.route)
        {
            DetailsScreen()
        }
    }
}