package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class Timetable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetable)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val startNewActivity = Intent(this, MainMenu::class.java)
            startActivity(startNewActivity)
        }

    }
    fun onClick(v: View) {
        val textView = findViewById<TextView>(R.id.TV_TimeTable)
        when (v.id) {
            R.id.btnMn -> textView.text = "Понедельник\n" +
                    "Системы аналитической обработки данных\n" +
                    "пр. занятие\n" +
                    "синхронно\n" +
                    "14:10–15:45\n" +
                    "Корпус №17, ауд. 4-20\n" +
                    "Якунин Ю. Ю.\n" +
                    "Системы аналитической обработки данных\n" +
                    "лекция\n" +
                    "синхронно\n" +
                    "15:55-17:30\n" +
                    "Корпус №17, ауд. 5-15\n" +
                    "Якунин Ю. Ю.\n" +
                    "Экономическая культура и финансовая грамотность\n" +
                    "пр. занятие\n" +
                    "синхронно\n" +
                    "17:40–19:15\n" +
                    "Корпус №17, ауд. 2-20\n" +
                    "Зябликов Д.В.\n"
            R.id.btnTu -> textView.text = "Вторник\n" +
                    "День военной подготовки\n" +
                    "синхронно\n" +
                    "08:30–10:05\n" +
                    "День военной подготовки\n" +
                    "синхронно\n" +
                    "10:15–11:50\n" +
                    "День военной подготовки\n" +
                    "синхронно\n" +
                    "12:00–13:35\n" +
                    "День военной подготовки\n" +
                    "синхронно\n" +
                    "14:10–15:45\n" +
                    "День военной подготовки\n" +
                    "синхронно\n" +
                    "15:55–17:30\n" +
                    "День военной подготовки\n" +
                    "синхронно\n" +
                    "17:40–19:15"
            R.id.btnWe -> textView.text = "Среда\n" +
                    "Системы аналитической обработки данных\n" +
                    "пр. занятие\n" +
                    "синхронно\n" +
                    "14:10–15:45\n" +
                    "Корпус №17, ауд. 4-13\n" +
                    "Якунин Ю. Ю.\n" +
                    "Экономическая культура и финансовая грамотность\n" +
                    "пр. занятие\n" +
                    "синхронно\n" +
                    "15:55–17:30\n" +
                    "Корпус №17, ауд. 2-20\n" +
                    "Зябликов Д. В.\n" +
                    "Экономическая культура и финансовая грамотность\n" +
                    "лекция\n" +
                    "синхронно\n" +
                    "17:40–19:15\n" +
                    "Корпус №17, ауд. 1-15\n" +
                    "Зябликов Д. В."
            R.id.btnTh -> textView.text = "Четверг\n" +
                    "Командный курсовой проект\n" +
                    "пр. занятие\n" +
                    "асинхронно\n" +
                    "12:00–13:35\n" +
                    "ЭИОС\n" +
                    "Хныкин А. В.\n" +
                    "Командный курсовой проект\n" +
                    "пр. занятие\n" +
                    "асинхронно\n" +
                    "14:10–15:45\n" +
                    "ЭИОС\n" +
                    "Хныкин А. В."
            R.id.btnFr -> textView.text = "Пятница\n" +
                    " Занятий нет"
            R.id.btnSa -> textView.text = "Суббота\n" +
                    " Занятий нет"
            R.id.btnSu -> textView.text = "Восресенье\n" +
                    " Занятий нет"
        }
    }
}