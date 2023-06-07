package com.example.llshopingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FoodItemListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_item_list)
        val showCartButton = Button(this)
        showCartButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra(KEY_MSG, "Hello From Main")
            startActivity(intent)
        }
    }
    companion object {
            const val KEY_MSG = "MSG"
        }
}