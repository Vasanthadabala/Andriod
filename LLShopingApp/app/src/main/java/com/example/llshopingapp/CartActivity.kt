package com.example.llshopingapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val textViewMessage = findViewById<TextView>(R.id.text_view_message)
        val message=intent.getStringExtra(FoodItemListActivity.KEY_MSG)
        textViewMessage.text=message
    }
}