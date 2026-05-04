package com.example.cognitivehealthapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val resultText = findViewById<TextView>(R.id.resultText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        resultText.text = "You scored $score / $total"

        feedbackText.text = when {
            total > 0 && score == total -> "Excellent work! Keep practising daily."
            total > 0 && score >= total / 2 -> "Good effort! Continue daily brain exercises."
            else -> "Keep practising. Try memory games, word quizzes, and maths puzzles."
        }
    }
}
