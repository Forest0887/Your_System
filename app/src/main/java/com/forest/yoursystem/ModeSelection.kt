package com.forest.yoursystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ModeSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mode_selection)

        val btnOffline = findViewById<Button>(R.id.btnOffline)
        val text = findViewById<TextView>(R.id.testText)
        btnOffline.setOnClickListener {
            text.text = "Ты нажал на кнопку. Ура."
        }
    }
}