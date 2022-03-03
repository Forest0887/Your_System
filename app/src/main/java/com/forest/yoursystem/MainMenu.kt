package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        val btnTimetable = findViewById<Button>(R.id.btnTimetable)
        btnTimetable.setOnClickListener {
            val startNewActivity = Intent(this, Timetable::class.java)
            startActivity(startNewActivity)
        }

        val btnNotes = findViewById<Button>(R.id.btnNotes)
        btnNotes.setOnClickListener {
            val startNewActivity = Intent(this, Notes::class.java)
            startActivity(startNewActivity)
        }

        val btnProgress = findViewById<Button>(R.id.btnProgress)
        btnProgress.setOnClickListener {
            val startNewActivity = Intent(this, Progress::class.java)
            startActivity(startNewActivity)
        }

        val btnSettings = findViewById<Button>(R.id.btnSettings)
        btnSettings.setOnClickListener {
            val startNewActivity = Intent(this, Settings::class.java)
            startActivity(startNewActivity)
        }

    }
}