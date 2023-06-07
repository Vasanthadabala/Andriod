package com.example.defining_listeners

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)//Listener Without Lambda
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                showToast("Button clicked")
            }
        })
        val button1 =findViewById<Button>(R.id.button1)//Listener using Lambda
        button1.setOnClickListener { view ->
            showToast("Data Saved")
        }
        val checkBox=findViewById<CheckBox>(R.id.checkbox)
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            showToast("Check Box is checked $isChecked")
        }
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}