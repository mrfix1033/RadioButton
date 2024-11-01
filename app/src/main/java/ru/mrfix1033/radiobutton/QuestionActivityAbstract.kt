package ru.mrfix1033.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

abstract class QuestionActivityAbstract(
    val correctAnswerCheckedId: Int,
    val activityId: Int,
    val nextActivityJavaClass: Class<out AppCompatActivity>
) : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityId)

        var score = intent.getIntExtra("score", 0)

        radioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if (radioGroup.checkedRadioButtonId == correctAnswerCheckedId)
                score += 100
            val intent = Intent(this, nextActivityJavaClass)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}