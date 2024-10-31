package ru.mrfix1033.radiobutton

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

abstract class QuestionActivityAbstract(
    val correctAnswerCheckedId: Int,
    val activityId: Int,
    val nextActivityJavaClass: Class<out AppCompatActivity>
) : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var textViewState: TextView
    private lateinit var buttonGetAnswerOrNext: Button
    private var buttonIsClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityId)

        var score = intent.getIntExtra("score", 0)

        radioGroup = findViewById(R.id.radioGroup)
        textViewState = findViewById(R.id.textViewState)
        buttonGetAnswerOrNext = findViewById(R.id.buttonGetAnswerOrNext)

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            buttonGetAnswerOrNext.isVisible = true
        }

        buttonGetAnswerOrNext.setOnClickListener {
            if (buttonIsClicked) {
                val intent = Intent(this, nextActivityJavaClass)
                intent.putExtra("score", score)
                startActivity(intent)
            } else {
                if (radioGroup.checkedRadioButtonId == correctAnswerCheckedId) {
                    textViewState.text = getString(R.string.correct)
                    textViewState.setTextColor(Color.GREEN)
                    score += 100
                } else {
                    textViewState.text =
                        getString(R.string.incorrect).format(findViewById<RadioButton>(correctAnswerCheckedId)!!.text)
                    textViewState.setTextColor(Color.RED)
                }
                buttonIsClicked = true
                buttonGetAnswerOrNext.setText(R.string.next_question)
            }
        }
    }
}