package com.example.cognitivehealthapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val conditionSpinner = findViewById<Spinner>(R.id.conditionSpinner)
        val registerBtn = findViewById<Button>(R.id.registerBtn)

        val conditions = arrayOf("None", "Memory Issues", "Stress", "Dementia Risk")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, conditions)
        conditionSpinner.adapter = adapter

        registerBtn.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val condition = conditionSpinner.selectedItem.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("CONDITION", condition)
            startActivity(intent)
            finish()
        }
    }
}
