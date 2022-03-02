package com.forest.yoursystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_screen)


        val text = findViewById<TextView>(R.id.greetings)
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            //text.text = "Ты нажал на кнопку. Ура."
            //println("test------------------------------------------")
            setContentView(R.layout.mode_selection)

         }
    }
}