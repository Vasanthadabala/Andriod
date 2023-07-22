package com.example.jsongson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.jsongson.ui.theme.JSONGsonTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JSONGsonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    jsonPlayGround()
                }
            }
        }
    }
}
private fun jsonPlayGround()
{
    val reservationJson=
        """
        {
        "date":"2022/12/30",
        "reservations":[
        {
        "tableFor":2,
        "time":"19:30"
        },
        {
        "tableFor":4,
        "time":"19:30"
        }
        ]
        }
        """
    val gson=Gson()
    val allReservations=gson.fromJson(reservationJson,AllReservations::class.java)
    allReservations.reservations.forEach{reservation ->
        println("""
            Reservation Time:${reservation.time}
            Reservation TableFor:${reservation.tableFor}
        """.trimIndent())
    }
}

data class Reservation(
    val tableFor:Int,
    val time:String
)
data class AllReservations(
    val date:String,
    val reservations:List<Reservation>
)