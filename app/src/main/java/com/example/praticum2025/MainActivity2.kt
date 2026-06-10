package com.example.praticum2025

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    // Array that stores the days of the week
    val days = arrayOf(
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"
    )
    // Array that stores minimum temperatures
    val minTemps = IntArray(7)

    // Array that stores maximum temperatures
    val maxTemps = IntArray(7)

    // Array that stores weather conditions
     val conditions = Array(7) { "" }

    // This variable keeps track of the next available array position
    var index = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        // Input fields
        val edtMin = findViewById<EditText>(R.id.edtMin)
        val edtMax = findViewById<EditText>(R.id.edtMax)
        val edtCondition = findViewById<EditText>(R.id.edtConditiion)

        // TextView to display the current day and average result
        val txtDay = findViewById<TextView>(R.id.txtDay)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)
        
        // Buttons
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnClear = findViewById<Button>(R.id.btnClear)

        // Shows the first day when the app starts
        txtDay.text = "Enter weather for: ${days[index]}"




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}