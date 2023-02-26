package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.forest.yoursystem.db.MyAdapter
import com.forest.yoursystem.db.MyDBManager

// Меню заметок
class Notes : AppCompatActivity() {

    private val myDBManager = MyDBManager(this)
    private val myAdapter = MyAdapter(ArrayList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes)
        myDBManager.openDB()
        initAdapter()

        // Назад в главное меню
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val startNewActivity = Intent(this, MainMenu::class.java)
            startActivity(startNewActivity)
        }

        // Создание новой заметки
        val btnNewNote = findViewById<Button>(R.id.btnNewNote)
        btnNewNote.setOnClickListener {
            val startNewActivity = Intent(this, NewNote::class.java)
            startActivity(startNewActivity)
        }
    }

    private fun getSwapMg(): ItemTouchHelper{
        return ItemTouchHelper(object : ItemTouchHelper.
        SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT ){
            override fun onMove(
                p0: RecyclerView,
                p1: RecyclerView.ViewHolder,
                p2: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, p1: Int) {
                myAdapter.removeItem(viewHolder.adapterPosition, myDBManager)
            }

        })
    }

    // Считывание элементов из Бд при повторном открытии заметок (на случай если появились новые)
    override fun onResume() {
        super.onResume()
        fillAdapter()
    }

    // Закрытие БД при закрытии приложения
    override fun onDestroy() {
        super.onDestroy()
        myDBManager.closeDB()
    }

    //
    private fun initAdapter(){
        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.layoutManager = LinearLayoutManager(this) // Указываем что элементы будут располагаться по вертикали
        val swapHelper = getSwapMg()
        swapHelper.attachToRecyclerView(rcView)
        rcView.adapter = myAdapter
    }

    // Считывание элементов из БД и закидывание их в адаптер который отрисует их
    private fun fillAdapter(){
        myAdapter.updateAdapter(myDBManager.readDBData()) // вернет список строк из БД
    }
}