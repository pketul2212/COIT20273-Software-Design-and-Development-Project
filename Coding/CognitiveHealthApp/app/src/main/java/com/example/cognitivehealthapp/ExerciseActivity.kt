package com.example.cognitivehealthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ExerciseActivity : AppCompatActivity() {

    private var index = 0
    private var score = 0
    private lateinit var questions: List<Pair<String, String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val conditionText = findViewById<TextView>(R.id.conditionText)
        val questionText = findViewById<TextView>(R.id.questionText)
        val answerInput = findViewById<EditText>(R.id.answerInput)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        val condition = intent.getStringExtra("CONDITION") ?: "None"
        conditionText.text = "Condition: $condition"

        questions = when (condition.lowercase()) {
            "memory issues" -> listOf(
                Pair("Remember this number: 8392. What was it?", "8392"),
                Pair("Remember: Apple Chair River. What was the second word?", "Chair"),
                Pair("What is 5 + 5?", "10")
            )
            "stress" -> listOf(
                Pair("Which activity helps reduce stress: meditation or shouting?", "meditation"),
                Pair("What is 4 + 5?", "9"),
                Pair("Name one calming exercise: yoga or running?", "yoga")
            )
            "dementia risk" -> listOf(
                Pair("What day comes after Monday?", "Tuesday"),
                Pair("What is 3 + 3?", "6"),
                Pair("Which is a fruit: Apple or Chair?", "Apple")
            )
            else -> listOf(
                Pair("What is 5 + 3?", "8"),
                Pair("Capital of France?", "Paris"),
                Pair("Which planet is known as the Red Planet?", "Mars")
            )
        }

        fun loadQuestion() {
            questionText.text = "Q${index + 1}: ${questions[index].first}"
            answerInput.text.clear()
        }

        loadQuestion()

        submitBtn.setOnClickListener {
            val answer = answerInput.text.toString().trim()

            if (answer.isEmpty()) {
                Toast.makeText(this, "Enter your answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (answer.equals(questions[index].second, ignoreCase = true)) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }

            index++

            if (index < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this, ResultsActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }
}
