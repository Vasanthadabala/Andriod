package com.example.testing

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PriceCalculatorTest
{
    private val classUnderTest=PriceCalculator()
    @Test
    fun validatecalculation() {
        val  result=classUnderTest.calculatePrice(3.00,5.00,0.20)
        assertEquals(9.60,result,0.001)
    }
}