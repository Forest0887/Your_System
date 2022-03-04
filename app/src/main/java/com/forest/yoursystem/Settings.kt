package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val startNewActivity = Intent(this, MainMenu::class.java)
            startActivity(startNewActivity)
        }

        val btnWorkingMode = findViewById<Button>(R.id.btnWorkingMode)
        btnWorkingMode.setOnClickListener {
            val startNewActivity = Intent(this, ModeSelection::class.java)
            startActivity(startNewActivity)
        }

        val btnInfo = findViewById<Button>(R.id.btnInfo)
        btnInfo.setOnClickListener {
            val startNewActivity = Intent(this, Info::class.java)
            startActivity(startNewActivity)
        }

        val btnLanguage = findViewById<Button>(R.id.btnLanguage)
        btnLanguage.setOnClickListener {
            val startNewActivity = Intent(this, Language::class.java)
            startActivity(startNewActivity)
        }

        val btnTetrisMenu = findViewById<Button>(R.id.btnTetris)
        btnTetrisMenu.setOnClickListener {
            val startNewActivity = Intent(this, TetrisMenu::class.java)
            startActivity(startNewActivity)
        }

    }
}