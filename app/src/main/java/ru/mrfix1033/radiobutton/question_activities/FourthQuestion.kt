package ru.mrfix1033.radiobutton.question_activities

import ru.mrfix1033.radiobutton.QuestionActivityAbstract
import ru.mrfix1033.radiobutton.R

class FourthQuestion : QuestionActivityAbstract(
    R.id.radioButton3,
    R.layout.activity_fourth_question,
    FifthQuestion::class.java
)