package com.example.cognitivehealthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.usernameInput)
        val password = findViewById<EditText>(R.id.passwordInput)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val registerLink = findViewById<TextView?>(R.id.registerLink)

        loginBtn.setOnClickListener {
            val user = username.text.toString().trim()
            val pass = password.text.toString().trim()

            if (user.isNotEmpty() && pass.isNotEmpty()) {
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("USER_NAME", user)
                intent.putExtra("CONDITION", "None")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Enter username and password", Toast.LENGTH_SHORT).show()
            }
        }

        registerLink?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
