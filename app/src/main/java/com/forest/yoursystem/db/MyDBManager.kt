package com.forest.yoursystem.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

// Открытие базы данных
// Ввод и считываение данных
class MyDBManager(context: Context) {
    val myDBHelper = MyDBHelper(context)
    var db : SQLiteDatabase? = null

    fun openDB() {
        db = myDBHelper.writableDatabase
    }

    // Ввод данных в БД
    fun insertToDB(note: String) {
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NAME_NOTE, note)
        }
        db?.insert(MyDBNameClass.TABLE_NAME, null, values)
    }

    fun updateItem(note: String, id:Int) {
        val selection = BaseColumns._ID + "=$id"
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NAME_NOTE, note)
        }
        db?.update(MyDBNameClass.TABLE_NAME, values, selection, null)
    }

    // Удаление данных из БД
    fun removeItemFromDB(id: String) {
        val selection = BaseColumns._ID + "=$id"
        db?.delete(MyDBNameClass.TABLE_NAME, selection, null)
    }

    // Считывание из БД
    fun readDBData() : ArrayList<ListItem> {
        val dataList = ArrayList<ListItem>()
        val cursor = db?.query(MyDBNameClass.TABLE_NAME,null, null,
                    null, null, null, null)
        with(cursor){
            while(this?.moveToNext()!!){
                val dataText = cursor?.getString(cursor.getColumnIndexOrThrow(MyDBNameClass.COLUMN_NAME_NOTE))
                val dataId = cursor?.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID))
                val item = ListItem()
                item.note = dataText.toString()
                if (dataId != null) {
                    item.id = dataId
                }
                dataList.add(item)
            }
        }
        cursor?.close()
        return dataList
    }

    fun closeDB(){
        myDBHelper.close()
    }
}