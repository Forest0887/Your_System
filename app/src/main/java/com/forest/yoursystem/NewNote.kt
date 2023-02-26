package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.forest.yoursystem.db.MyDBManager
import com.forest.yoursystem.db.MyIntentConstants

// Создание новой заметки
class NewNote : AppCompatActivity() {

    private val myDBManager = MyDBManager(this)
    var id = 0
    var isEditState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_note)
        myDBManager.openDB()
        getMyIntents()

        // Возвращение в меню заметок
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val startNewActivity = Intent(this, Notes::class.java)
            startActivity(startNewActivity)
        }

        // Сохранение заметки в БД
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val editText  = findViewById<EditText>(R.id.inputNote).text.toString()
            if (editText != "")
                if (isEditState){
                    myDBManager.updateItem(editText, id)
                } else {
                    myDBManager.insertToDB(editText)
                }
            finish()
        }
    }

    fun getMyIntents(){
        val i = intent
        if (i != null){
            if (i.getStringExtra(MyIntentConstants.I_NOTE_KEY) != null){
                isEditState = true
                id = i.getIntExtra(MyIntentConstants.I_ID_KEY, 0)
                findViewById<EditText>(R.id.inputNote).setText(i.getStringExtra(MyIntentConstants.I_NOTE_KEY))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDBManager.closeDB()
    }
}