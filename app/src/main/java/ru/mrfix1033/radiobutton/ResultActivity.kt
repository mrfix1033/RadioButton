package ru.mrfix1033.radiobutton

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewScore: TextView
    private lateinit var textViewDescription: TextView
    private lateinit var buttonExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewScore = findViewById(R.id.textViewScore)
        textViewDescription = findViewById(R.id.textViewDescription)
        buttonExit = findViewById(R.id.buttonExit)

        val score = intent.getIntExtra("score", 0)
        textViewScore.text = score.toString()
        textViewDescription.text = getString(when (score) {
            0 -> R.string.score0
            100 -> R.string.score100
            200 -> R.string.score00
            300 -> R.string.score300
            400 -> R.string.score400
            500 -> R.string.score500
            else -> R.string.scoreError
        })
        buttonExit.setOnClickListener {
            finishAffinity()
        }
    }
}