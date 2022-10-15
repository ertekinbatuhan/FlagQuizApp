package com.batuhanberkertekin.flagquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
           dataBaseCopy()

           startButton.setOnClickListener {
               val intent = Intent(applicationContext,QuizActivity::class.java)
               startActivity(intent)

           }


    }

    fun dataBaseCopy(){


        val copyHelper = DatabaseCopyHelper(applicationContext)


        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e : Exception){
            e.printStackTrace()
        }
    }



}