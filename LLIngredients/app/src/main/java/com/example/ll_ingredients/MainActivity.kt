package com.example.ll_ingredients

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.ll_ingredients.IngredientsActivity.Companion.start

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.main_dish_1).setOnClickListener {
         start(this,"Hamburger")
        }
        findViewById<View>(R.id.main_dish_2).setOnClickListener {
           start(this,"Pasta")
        }
    }
}