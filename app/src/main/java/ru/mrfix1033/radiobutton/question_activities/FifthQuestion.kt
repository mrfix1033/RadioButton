package ru.mrfix1033.radiobutton.question_activities

import ru.mrfix1033.radiobutton.QuestionActivityAbstract
import ru.mrfix1033.radiobutton.R
import ru.mrfix1033.radiobutton.ResultActivity

class FifthQuestion : QuestionActivityAbstract(
    R.id.radioButton3,
    R.layout.activity_fifth_question,
    ResultActivity::class.java
)