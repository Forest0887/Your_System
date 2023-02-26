package com.forest.yoursystem.db

import android.provider.BaseColumns

// Создание БД
object MyDBNameClass {
    const val TABLE_NAME = "table_notes"    // Имя таблицы
    const val COLUMN_NAME_NOTE = "notes"    // Имя колонны

    const val DATABASE_VERSION = 1 // Миграция
    const val DATABASE_NAME = "Notes.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            " ${BaseColumns._ID} INTEGER PRIMARY KEY, " +
            " $COLUMN_NAME_NOTE TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

}