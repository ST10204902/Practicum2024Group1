package za.co.varsitycollege.st10204902.practicum2024group1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)

        val dayOfWeek =
            arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val minTemp = intArrayOf(15, 16, 14, 17, 18, 19, 20)
        val maxTemp = intArrayOf(25, 26, 24, 27, 28, 29, 30)
        val condition = arrayOf("Sunny", "Cloudy", "Rainy", "Windy", "Stormy", "Snowy", "Foggy")

        val averageTemperatureTextView = findViewById<TextView>(R.id.averageTemperatureTextView)
        val viewDetailsButton = findViewById<TextView>(R.id.viewDetailsButton)
        val exitButton = findViewById<TextView>(R.id.exitButton)

        val averageTemperatureValue = calculateAverageTemperature(minTemp, maxTemp)

        val formattedAverage = "Average Temperature:" + averageTemperatureValue

        averageTemperatureTextView.text = formattedAverage

        viewDetailsButton.setOnClickListener {
            // Navigate to DetailedActivity
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("dayOfWeek", dayOfWeek)
            intent.putExtra("minTemp", minTemp)
            intent.putExtra("maxTemp", maxTemp)
            intent.putExtra("condition", condition)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            // Exit the application
            finishAffinity()
        }
    }

    fun calculateAverageTemperature(minTemp: IntArray, maxTemp: IntArray): Double {
        var minTotal = 0
        var maxTotal = 0

        for (i in minTemp.indices) {
            minTotal += minTemp[i]
        }

        for (i in maxTemp.indices) {
            maxTotal += maxTemp[i]
        }

        val count = minTemp.size + maxTemp.size + 0.0 // Using 0.0 to ensure the result is a Double

        val average = (minTotal + maxTotal) / (count)

        return average
    }
}