package za.co.varsitycollege.st10204902.practicum2024group1

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)

        val dayOfWeek = intent.getStringArrayExtra("dayOfWeek")
        val minTemp = intent.getIntArrayExtra("minTemp")
        val maxTemp = intent.getIntArrayExtra("maxTemp")
        val condition = intent.getStringArrayExtra("condition")

        val backButton = findViewById<AppCompatButton>(R.id.backButton)
        val container = findViewById<LinearLayout>(R.id.scrollLinearLayout)

        backButton.setOnClickListener {
            // Navigate back to WeatherActivity
            finish() // This will close the DetailedActivity and return to the previous activity
        }

        if(dayOfWeek!= null && minTemp != null && maxTemp != null && condition != null) {
            for (i in dayOfWeek.indices) {
                val dayLayout = LinearLayout(this).apply{
                    orientation = LinearLayout.VERTICAL
                    setPadding(32, 24, 32, 24)
                    setBackgroundColor("#F5F5F5".toColorInt())
                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(24, 16, 24, 16)
                    layoutParams = params
                }

                val dayTxt = TextView(this).apply {
                    text = dayOfWeek[i]
                    textSize = 24f
                    setTextColor("#333333".toColorInt())
                }

                val minTempTxt = TextView(this).apply {
                    text = "Min Temp: ${minTemp[i]}°C"
                    textSize = 18f
                    setTextColor("#555555".toColorInt())
                }

                val maxTempTxt = TextView(this).apply {
                    text = "Max Temp: ${maxTemp[i]}°C"
                    textSize = 18f
                    setTextColor("#555555".toColorInt())
                }

                val conditionTxt = TextView(this).apply {
                    text = "Condition: ${condition[i]}"
                    textSize = 18f
                    setTextColor("#555555".toColorInt())
                }

                dayLayout.addView(dayTxt)
                dayLayout.addView(minTempTxt)
                dayLayout.addView(maxTempTxt)
                dayLayout.addView(conditionTxt)
                container.addView(dayLayout)
            }
        }
    }
}