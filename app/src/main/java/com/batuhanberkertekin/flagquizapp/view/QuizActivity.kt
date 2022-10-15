package com.batuhanberkertekin.flagquizapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.batuhanberkertekin.flagquizapp.R
import com.batuhanberkertekin.flagquizapp.data.Bayraklar
import com.batuhanberkertekin.flagquizapp.database.BayraklarDao
import com.batuhanberkertekin.flagquizapp.database.DataBaseHelper
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    private lateinit var vt : DataBaseHelper
    private var questionCounter = 0
    private  var trueCounter = 0
    private var falseCounter =0
    private lateinit var questions : ArrayList<Bayraklar>
    private lateinit var falseOption : ArrayList<Bayraklar>
    private lateinit var trueQuestion : Bayraklar
    private lateinit var allOption : HashSet<Bayraklar>    //sırayı karıştırıyor o yüzden HashSet kulandık
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        vt = DataBaseHelper(applicationContext)
        val bayraklarDao = BayraklarDao()
        questions = bayraklarDao.randomBayrak(vt)
        uploadQuestion()


       button.setOnClickListener {
           trueControl(button)
           questionControl()
       }
        button2.setOnClickListener {
            trueControl(button2)
            questionControl()
        }
        button3.setOnClickListener {
            trueControl(button3)
            questionControl()
        }
        button4.setOnClickListener {
            trueControl(button4)
            questionControl()
        }
    }

    fun uploadQuestion(){
        questionText.text ="${questionCounter + 1} . Question"

        trueQuestion = questions.get(questionCounter)

        flagView.setImageResource(resources.getIdentifier(trueQuestion.bayrak_resim,"drawable",packageName))

        falseOption = BayraklarDao().randomFalseAnswer(vt,trueQuestion.bayrak_id)
        allOption = HashSet()
        allOption.add(trueQuestion)
        allOption.add(falseOption.get(0))
        allOption.add(falseOption.get(1))
        allOption.add(falseOption.get(2))

        button.text = allOption.elementAt(0).bayrak_name
        button2.text = allOption.elementAt(1).bayrak_name
        button3.text = allOption.elementAt(2).bayrak_name
        button4.text = allOption.elementAt(3).bayrak_name
    }

    fun questionControl() {
        questionCounter++

        if (questionCounter != 5) {
            uploadQuestion()

        } else {

            val intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("trueCounter",trueCounter)




            finish()
            startActivity(intent)
        }
    }
        fun trueControl(button : Button){
            val buttonWriting = button.text.toString()
            val trueAnswer = trueQuestion.bayrak_name

            if(buttonWriting == trueAnswer){
                trueCounter++
            }else{
                falseCounter++
            }
              trueText.text = "True : $trueCounter"
              falseText.text ="False : $falseCounter"

        }
    }
