package com.batuhanberkertekin.flagquizapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(mcontext :Context) :
    SQLiteOpenHelper(mcontext,"bayrakquiz.sqlite",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {


        db?.execSQL("CREATE TABLE IF NOT EXISTS bayraklar(bayrak_no INTEGER PRIMARY KEY AUTOINCREMENT,bayrak_name TEXT ," +
                "bayrak_resim TEXT);" )




    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


        db?.execSQL("DROP TABLE IF EXISTS bayraklar")

        onCreate(db)

    }
}