package com.example.testing

class PriceCalculator {
    fun calculatePrice(item1:Double,item2:Double,taxrate:Double):Double
    {
        return(item1+item2)*(1.0+taxrate)
    }
}