package com.forest.yoursystem.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, MyDBNameClass.DATABASE_NAME,
                                               null, MyDBNameClass.DATABASE_VERSION)
{
    // Создание БД
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDBNameClass.CREATE_TABLE)
    }

    // Удаление БД
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(MyDBNameClass.SQL_DELETE_TABLE)
        onCreate(db)
    }

}