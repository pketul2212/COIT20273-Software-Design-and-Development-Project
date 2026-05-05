package com.example.cognitivehealthapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DoctorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)

        findViewById<Button>(R.id.bookBtn).setOnClickListener {
            showBookingMessage("Dr. John Smith")
        }

        findViewById<Button>(R.id.bookBtn2).setOnClickListener {
            showBookingMessage("Dr. Emma Wilson")
        }
    }

    private fun showBookingMessage(doctorName: String) {
        Toast.makeText(this, "Appointment requested with $doctorName", Toast.LENGTH_SHORT).show()
    }
}
