package ru.mrfix1033.radiobutton.question_activities

import ru.mrfix1033.radiobutton.QuestionActivityAbstract
import ru.mrfix1033.radiobutton.R

class ThirdQuestion : QuestionActivityAbstract(
    R.id.radioButton2,
    R.layout.activity_third_question,
    FourthQuestion::class.java
)