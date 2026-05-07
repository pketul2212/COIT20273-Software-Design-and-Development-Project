package com.example.cognitivehealthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private var condition: String = "None"
    private var userName: String = "User"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard2)

        condition = intent.getStringExtra("CONDITION") ?: "None"
        userName = intent.getStringExtra("USER_NAME") ?: "User"

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val conditionText = findViewById<TextView>(R.id.conditionText)
        val exerciseBtn = findViewById<Button>(R.id.exerciseBtn)
        val chatbotBtn = findViewById<Button>(R.id.chatbotBtn)
        val doctorBtn = findViewById<Button>(R.id.doctorBtn)

        welcomeText.text = "Welcome, $userName 👋"
        conditionText.text = "Condition: $condition"

        exerciseBtn.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            intent.putExtra("CONDITION", condition)
            startActivity(intent)
        }

        chatbotBtn.setOnClickListener {
            startActivity(Intent(this, ChatbotActivity::class.java))
        }

        doctorBtn.setOnClickListener {
            startActivity(Intent(this, DoctorActivity::class.java))
        }
    }
}
