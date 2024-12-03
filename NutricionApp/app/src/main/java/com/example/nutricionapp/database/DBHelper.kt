package com.example.gealth.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Definir el nombre y versión de la base de datos
const val DATABASE_NAME = "GealthDB"
const val DATABASE_VERSION = 1

// Tabla de usuarios
const val TABLE_USERS = "users"
const val COLUMN_ID = "id"
const val COLUMN_NAME = "name"
const val COLUMN_EMAIL = "email"

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // Crear la tabla de usuarios
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USERS_TABLE = ("CREATE TABLE $TABLE_USERS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_EMAIL TEXT)")
        db?.execSQL(CREATE_USERS_TABLE)
    }

    // Si hay una actualización en la versión de la base de datos
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    // Insertar un nuevo usuario
    fun insertUser(name: String, email: String): Long {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_EMAIL, email)

        // Insertar la fila y devolver el ID de la nueva fila
        return db.insert(TABLE_USERS, null, values)
    }

    // Obtener todos los usuarios
    fun getAllUsers(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_USERS", null)
    }

    // Obtener un usuario por su ID
    fun getUserById(id: Int): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_USERS WHERE $COLUMN_ID = ?", arrayOf(id.toString()))
    }

    // Actualizar un usuario
    fun updateUser(id: Int, name: String, email: String): Int {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_EMAIL, email)

        // Actualizar la fila con el ID proporcionado
        return db.update(TABLE_USERS, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    // Eliminar un usuario
    fun deleteUser(id: Int): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_USERS, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
}
