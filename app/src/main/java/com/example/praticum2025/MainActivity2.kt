package com.example.praticum2025

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        // Save button stores the user's input into the arrays
        btnSave.setOnClickListener {

            // Get input from the EditText fields
            val minText = edtMin.text.toString()
            val maxText = edtMax.text.toString()
            val conditionText = edtCondition.text.toString()

            // Check if the user left any field empty
            if (minText.isEmpty() || maxText.isEmpty() || conditionText.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter all fields", Toast.LENGTH_SHORT
                ).show()
            }

            // Check if all 7 days have already been entered
            else if (index >= 7) {
                Toast.makeText(
                    this,
                    "The array is full", Toast.LENGTH_SHORT
                ).show()
            } else {
                // Convert text input to integers
                val min = minText.toInt()
                val max = maxText.toInt()

                // Store the values in parallel arrays using the same index to user later in loop
                minTemps[index] = min
                maxTemps[index] = max
                conditions[index] = conditionText

                // Show confirmation message
                Toast.makeText(
                    this,
                    "Weather saved for ${days[index]}",
                    Toast.LENGTH_SHORT
                ).show()

                // Move to the next day
                index++

                // Clear input fields after saving
                edtMin.text.clear()
                edtMax.text.clear()
                edtCondition.text.clear()

                // Update the day shown on the screen
                if (index < 7) {
                    txtDay.text = "Enter weather for: ${days[index]}"
                } else {
                    txtDay.text = "All 7 days entered"
                }
                // Average button calculates the weekly average temperature
                btnAverage.setOnClickListener {

                    // Prevent division by zero if no data has been entered
                    if (index == 0) {
                        Toast.makeText(this, "No data entered yet", Toast.LENGTH_SHORT).show()
                    } else {
                        var total = 0.0

                        // Loop through all entered days
                        //I = COUNTER
//                        for (i in 0 until index) {
                            // Calculate average temperature for one day
//                            val dailyAverage = (minTemps[i] + maxTemps[i]) / 2.0
                            // Add daily average to total
//                            total += dailyAverage
//                        }
                        // Calculate weekly average
//                        val weeklyAverage = total / index
                        //USING WHILE LOOP
//                        var i/Counter = 0

                        // Loop through all entered days
//                        while (i < index) {

                            // Calculate the average for one day
//                            val dailyAverage =
//                                (minTemps[i] + maxTemps[i]) / 2.0

                            // Add the daily average to the total
//                            total += dailyAverage

                            // Move to the next position in the array
//                            i++
//                        }

                        for (i in 0..index - 1) {

                            val dailyAverage =
                                (minTemps[i] + maxTemps[i]) / 2.0

                            total += dailyAverage
                        }

                        val weeklyAverage = total / index
//Display the result
                        txtAverage.text =
                            "Average Temperature: %.2f°C".format(weeklyAverage)
                    }
                    // Details button opens the detailed view screen
                    btnDetails.setOnClickListener {

                        val intent = Intent(this, DetailActivity::class.java)

                        // Send arrays and index to the detailed screen
                        intent.putExtra("days", days)
                        intent.putExtra("minTemps", minTemps)
                        intent.putExtra("maxTemps", maxTemps)
                        intent.putExtra("conditions", conditions)
                        intent.putExtra("index", index)

                        startActivity(intent)
                    }

                    // Clear button resets the app data
                    btnClear.setOnClickListener {

                        // Reset index so the user can start entering data again
                        index = 0

                        // Clear output text
                        txtAverage.text = ""
                        txtDay.text = "Enter weather for: ${days[index]}"

                        // Clear input fields
                        edtMin.text.clear()
                        edtMax.text.clear()
                        edtCondition.text.clear()

                        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
                    }






                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets
                }
            }
        }
    }}}