package ru.mrfix1033.radiobutton

import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        radioGroup.setOnCheckedChangeListener { group, checked -> changeColorAndNotify(checked) }
        radioGroup.setOnClickListener {
            notify("Промахнулся)")
        }

        button.setOnClickListener {
            val checkedId = radioGroup.checkedRadioButtonId
            if (checkedId == -1) {
                notify("Ничего не выбрано")
                return@setOnClickListener
            }
            changeColorAndNotify(checkedId)
        }

        textView.setOnClickListener {notify("Да не сюда")}
    }

    private fun changeColor(radioButtonId: Int) {
        textView.setBackgroundColor(
            when (radioButtonId) {
                R.id.radioButtonDefault -> getColor(R.color.background)
                R.id.radioButtonRed -> Color.RED
                R.id.radioButtonGreen -> Color.GREEN
                R.id.radioButtonBlue -> Color.BLUE
                else -> Color.BLACK
            }
        )
    }

    private fun changeColorAndNotify(radioButtonId: Int) {
        changeColor(radioButtonId)
        val radio = findViewById<RadioButton>(radioButtonId)
        notify("Цвет изменён на ${radio.text.toString().lowercase()}")
    }

    private fun notify(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}