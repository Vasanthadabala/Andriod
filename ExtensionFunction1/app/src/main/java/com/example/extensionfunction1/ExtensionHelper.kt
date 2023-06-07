package com.example.extensionfunction1

import android.widget.TextView

fun Int.getFormattedAmount():String
{
    if(this>0)
    {
        return this.toString()
    }
    else
    {
        return "Out of stock"
    }
}
fun TextView.appendText(textToAppend:String)
{
    val newText="$text \n $textToAppend"
    text=newText
}