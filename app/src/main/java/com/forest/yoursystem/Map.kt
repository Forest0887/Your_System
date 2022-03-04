package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Map : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val startNewActivity = Intent(this, Settings::class.java)
            startActivity(startNewActivity)
        }
    }
}