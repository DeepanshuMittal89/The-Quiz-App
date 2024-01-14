package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val User_name:TextView = findViewById(R.id.tv_user_name)
        val Score:TextView= findViewById(R.id.score)
        val finish:Button= findViewById(R.id.submit_button)

        User_name.text= intent.getStringExtra(Constants.USER_NAME)
        val Total_Questions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val Correct_Answers = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        Score.text = "Your score is $Correct_Answers out of $Total_Questions"

        finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}