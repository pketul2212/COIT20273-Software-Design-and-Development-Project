package com.example.cognitivehealthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DashboardActivity : AppCompatActivity() {

    private lateinit var exerciseBtn: Button
    private lateinit var reportBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Keep the layout name as activity_dashboard2 since you don't want to rename
        setContentView(R.layout.activity_dashboard2)

        // Make sure your layout file has these buttons with matching IDs
        exerciseBtn = findViewById(R.id.exerciseBtn)
        reportBtn = findViewById(R.id.reportBtn)

        // Navigate to ExerciseActivity when clicked
        exerciseBtn.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        // Placeholder for reports
        reportBtn.setOnClickListener {
            Toast.makeText(this, "Showing Progress Report...", Toast.LENGTH_SHORT).show()
        }
    }
}
