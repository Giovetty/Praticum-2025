package com.example.praticum2025

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Receive data from MainActivity
        val days = intent.getStringArrayExtra("days")
        val minTemps = intent.getIntArrayExtra("minTemps")
        val maxTemps = intent.getIntArrayExtra("maxTemps")
        val conditions = intent.getStringArrayExtra("conditions")
        val index = intent.getIntExtra("index", 0)

        //receive in sasha style
        //val bundle: Bundle? = intent.extras
        //val days = bundle?.getStringArray("days")
        //val minTemps = bundle?.getIntArray("minTemps")
        //val maxTemps = bundle?.getIntArray("maxTemps")
        //val conditions = bundle?.getStringArray("conditions")
        //val index = bundle?.getInt("index")

        var details = ""

        // Check if there is data to display
        if (index == 0) {
            details = "No weather data entered yet."
        } else {

            // Loop through all entered days and build the details text
            for (i in 0 until index) {
                details += "${days?.get(i)}\n"
                details += "Minimum temperature: ${minTemps?.get(i)}°C\n"
                details += "Maximum temperature: ${maxTemps?.get(i)}°C\n"
                details += "Weather condition: ${conditions?.get(i)}\n\n"
            }
        }
        //ANOTHER WAY OF DOING IT
        // Check if data exists
//        if (index == 0) {
//
//            details = "No weather data entered yet."

//        } else {

            // Display weather data for each day
//            var i = 0
//
//            while (i < index) {
//
//                details += "${days[i]}\n"
//                details += "Min Temperature: ${minTemps[i]}°C\n"
//                details += "Max Temperature: ${maxTemps[i]}°C\n"
//                details += "Condition: ${conditions[i]}\n\n"
//
//                i++
//            }

        // Display all details on the screen
        txtDetails.text = details

        // Go back to the main screen
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            //OR YOU CAN USE finish() To go back to main screen
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}