package com.batuhanberkertekin.flagquizapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.batuhanberkertekin.flagquizapp.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)



        val intent = getIntent().getIntExtra("trueCounter",0)


         resultText.text = "$intent TRUE ${5-intent} FALSE "
         percentResult.text = "% ${(intent*100) / 5} Success"




        tryAgainButton.setOnClickListener {


            val intent = Intent(applicationContext, MainActivity::class.java)
            finish()
            startActivity(intent)

        }
    }
}