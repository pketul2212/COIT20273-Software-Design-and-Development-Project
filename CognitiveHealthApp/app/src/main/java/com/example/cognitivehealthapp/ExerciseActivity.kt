package com.example.cognitivehealthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ExerciseActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var answerInput: EditText
    private lateinit var submitBtn: Button

    private val questions = listOf(
        Pair("What is 5 + 3?", "8"),
        Pair("What is the capital of France?", "Paris"),
        Pair("Which planet is known as the Red Planet?", "Mars")
    )

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        questionText = findViewById(R.id.questionText)
        answerInput = findViewById(R.id.answerInput)
        submitBtn = findViewById(R.id.submitBtn)

        loadQuestion()

        submitBtn.setOnClickListener {
            val answer = answerInput.text.toString().trim()
            if (answer.equals(questions[currentIndex].second, ignoreCase = true)) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }

            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
            } else {
                // Quiz finished → go to ResultsActivity
                val intent = Intent(this, ResultsActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[currentIndex].first
        answerInput.text.clear()
    }
}
