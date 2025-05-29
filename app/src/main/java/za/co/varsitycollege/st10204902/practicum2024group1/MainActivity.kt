package za.co.varsitycollege.st10204902.practicum2024group1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton = findViewById<AppCompatButton>(R.id.startButton)
        val exitButton = findViewById<AppCompatButton>(R.id.exitButton)

        startButton.setOnClickListener {
            // Navigate to WeatherActivity
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            // Exit the application
            finishAffinity() // This will close the app and remove it from the recent apps list
        }
    }
}