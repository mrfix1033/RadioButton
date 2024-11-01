package ru.mrfix1033.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.mrfix1033.radiobutton.question_activities.FirstQuestion

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonStart).setOnClickListener {
            val intent = Intent(this, FirstQuestion::class.java)
            startActivity(intent)
        }
    }
}