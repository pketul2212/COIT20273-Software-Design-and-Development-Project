package com.example.cognitivehealthapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ChatbotActivity : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var output: TextView
    private lateinit var sendBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        input = findViewById(R.id.chatInput)
        output = findViewById(R.id.chatOutput)
        sendBtn = findViewById(R.id.sendBtn)

        sendBtn.setOnClickListener {
            val userMessage = input.text.toString().trim()

            if (userMessage.isEmpty()) {
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val botReply = generateResponse(userMessage)

            // Show conversation (User + Bot)
            output.append("\n\nYou: $userMessage")
            output.append("\nBot: $botReply")

            input.text.clear()
        }
    }

    // 🔥 AI Logic (Rule-based chatbot)
    private fun generateResponse(message: String): String {

        return when {
            message.contains("stress", true) ->
                "Try meditation, deep breathing, or light exercise 🧘"

            message.contains("memory", true) ->
                "Practice memory games like puzzles, quizzes, or repetition 🧠"

            message.contains("sleep", true) ->
                "Maintain a regular sleep schedule and avoid screens before bed 😴"

            message.contains("exercise", true) ->
                "Brain exercises like math puzzles and reading help improve cognition 📚"

            message.contains("hello", true) || message.contains("hi", true) ->
                "Hello! How can I help you today? 😊"

            message.contains("doctor", true) ->
                "You can book an appointment from the Doctor section 👨‍⚕️"

            else ->
                "I recommend daily brain exercises and a healthy lifestyle 👍"
        }
    }
}