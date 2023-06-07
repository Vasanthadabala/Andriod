package com.example.extensionfunction1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProductsActivity : AppCompatActivity() {
    val products = listOf(
        Product("Steak", 5),
        Product("Spaghetti", 3),
        Product("Coffee", 10),
        Product("Croissant", 0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val textViewProducts=findViewById<TextView>(R.id.text_view_products)
        for (x in products) {
            textViewProducts.appendText("${x.title}(${x.amount.getFormattedAmount()}")
        }
    }
}
data class Product(val title: String, val amount: Int)