package com.example.ll_ingredients

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IngredientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        val dishName=intent.getStringExtra( EXTRA_DISH_NAME_KEY)
        findViewById<TextView>(R.id.ingredients_list).text=when(dishName)
        {
            "Hamnurger"->"Meat \n Bun \n Tomato"
            "Pasta"->"Spaghetti\nTomato\nParmesan"
            else->"Unknown"
        }

    }
    companion object{
        const val EXTRA_DISH_NAME_KEY="DishName"
        fun start(context:Context,dishName:String)
        {
            val intent=Intent(context,IngredientsActivity::class.java).apply {
                putExtra(EXTRA_DISH_NAME_KEY, dishName)
            }

            context.startActivity(intent)
        }
    }
}