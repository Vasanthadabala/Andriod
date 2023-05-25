package com.example.lazzylayout.data

import com.example.lazzylayout.R

data class Dish(
    val name:String,
    val price:String,
    val description:String,
    val image:Int
)
val dishes= listOf<Dish>(
    Dish("Greek Salad","$12.99",
        "The famous greek salad of crispy lettuce,peppers,olives and our Chicago...",
        R.drawable.greeksalad),
    Dish("Brushetta","$5.99",
        "The famous Burshetta with grilled Bread and Better",
        R.drawable.bruschetta),
    Dish("Grilled Fish","$10.99",
        "Grilled Fish with famous sacuces and vegies",
        R.drawable.grilledfish),
    Dish("Greek Salad","$12.99",
        "The famous greek salad of crispy lettuce,peppers,olives and our Chicago...",
        R.drawable.greeksalad),
    Dish("Greek Salad","$12.99",
        "The famous greek salad of crispy lettuce,peppers,olives and our Chicago...",
        R.drawable.greeksalad),
    Dish("Greek Salad","$12.99",
        "The famous greek salad of crispy lettuce,peppers,olives and our Chicago...",
        R.drawable.greeksalad),
    Dish("Greek Salad","$12.99",
        "The famous greek salad of crispy lettuce,peppers,olives and our Chicago...",
        R.drawable.greeksalad)
)
