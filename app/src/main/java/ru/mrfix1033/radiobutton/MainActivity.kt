package ru.mrfix1033.radiobutton

import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var radioButtonDefault: RadioButton
    private lateinit var radioButtonRed: RadioButton
    private lateinit var radioButtonGreen: RadioButton
    private lateinit var radioButtonBlue: RadioButton
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioButtonDefault = findViewById(R.id.radioButtonDefault)
        radioButtonRed = findViewById(R.id.radioButtonRed)
        radioButtonGreen = findViewById(R.id.radioButtonGreen)
        radioButtonBlue = findViewById(R.id.radioButtonBlue)
        textView = findViewById(R.id.textView)

        radioButtonDefault.setOnClickListener(radioButtonOnClickListener)
        radioButtonRed.setOnClickListener(radioButtonOnClickListener)
        radioButtonGreen.setOnClickListener(radioButtonOnClickListener)
        radioButtonBlue.setOnClickListener(radioButtonOnClickListener)
    }

    private var radioButtonOnClickListener = View.OnClickListener { view ->
        val radioButton = view as RadioButton
        textView.setBackgroundColor(
            when (radioButton.id) {
                R.id.radioButtonDefault -> getColor(R.color.background)
                R.id.radioButtonRed -> Color.RED
                R.id.radioButtonGreen -> Color.GREEN
                R.id.radioButtonBlue -> Color.BLUE
                else -> Color.BLACK
            }
        )
    }
}