package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton:Button = findViewById(R.id.start_btn)
        val editableText : EditText = findViewById(R.id.et_text)

        startButton.setOnClickListener{
            if(editableText.text.isEmpty()){
                Toast.makeText(this, "Enter your name !", Toast.LENGTH_SHORT).show()
            }
            else{
                intent = Intent(this,QuestionareActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}