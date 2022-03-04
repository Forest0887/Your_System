package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TetrisMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tetris_menu)
        supportActionBar?.hide()

        val btnExit = findViewById<Button>(R.id.btnExit)
        btnExit.setOnClickListener {
            val startNewActivity = Intent(this, Settings::class.java)
            startActivity(startNewActivity)
        }

    }
}