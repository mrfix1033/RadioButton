package ru.mrfix1033.radiobutton.question_activities

import ru.mrfix1033.radiobutton.QuestionActivityAbstract
import ru.mrfix1033.radiobutton.R

class FirstQuestion : QuestionActivityAbstract(
    R.id.radioButton1,
    R.layout.activity_first_question,
    SecondQuestion::class.java
)