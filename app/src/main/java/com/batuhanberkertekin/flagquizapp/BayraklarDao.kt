package com.batuhanberkertekin.flagquizapp

import android.annotation.SuppressLint
import com.batuhanberkertekin.flagquizapp.data.Bayraklar
import com.batuhanberkertekin.flagquizapp.database.DataBaseHelper

class BayraklarDao {


    @SuppressLint("Range")
    fun randomBayrak(vt : DataBaseHelper) : ArrayList<Bayraklar> {


          val flagsList = ArrayList<Bayraklar>()

        val db = vt.writableDatabase

        val b = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null)


        while (b.moveToNext()){


            val flag = Bayraklar(b.getInt(b.getColumnIndex("bayrak_id")),
            b.getString(b.getColumnIndex("bayrak_ad")),
            b.getString(b.getColumnIndex("bayrak_resim")))

            flagsList.add(flag)


        }
        return  flagsList
    }


    @SuppressLint("Range")
    fun randomFalseAnswer(vt : DataBaseHelper, bayrak_id : Int) : ArrayList<Bayraklar> {


        val flagsList = ArrayList<Bayraklar>()

        val db = vt.writableDatabase

        val b = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3",null)


        while (b.moveToNext()){


            val flag = Bayraklar(b.getInt(b.getColumnIndex("bayrak_id")),
                b.getString(b.getColumnIndex("bayrak_ad")),
                b.getString(b.getColumnIndex("bayrak_resim")))

            flagsList.add(flag)


        }
        return  flagsList
    }
}