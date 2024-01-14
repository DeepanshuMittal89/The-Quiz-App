package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.math.log

class QuestionareActivity : AppCompatActivity(), View.OnClickListener{
    private var mcurrentPosition:Int=1
    private var mquestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int?=0

    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?= null
    private var tvQuestion : TextView?=null
    private var ivImage: ImageView?=null
    private var btnOne: TextView?=null
    private var btnTwo: TextView?=null
    private var btnThree: TextView?=null
    private var btnFour: TextView?=null
    private var submitButton:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionare)
        tvQuestion = findViewById(R.id.tv_Question)
        ivImage = findViewById(R.id.iv_image)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        btnOne = findViewById(R.id.btn_One)
        btnTwo = findViewById(R.id.btn_Two)
        btnThree = findViewById(R.id.btn_Three)
        btnFour = findViewById(R.id.btn_Four)
        submitButton= findViewById(R.id.btn_Submit)

        btnOne?.setOnClickListener(this)
        btnTwo?.setOnClickListener(this)
        btnThree?.setOnClickListener(this)
        btnFour?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)

        mquestionList = Constants.getQuestion()

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mquestionList!![mcurrentPosition - 1]
        progressBar?.progress = mcurrentPosition
        tvProgress?.text = "$mcurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        btnOne?.text = question.optionOne
        btnTwo?.text = question.optionTwo
        btnThree?.text = question.optionThree
        btnFour?.text = question.optionFour

        if(mcurrentPosition == mquestionList!!.size){
            submitButton?.text="FINISH"
        }
        else{
            submitButton?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        btnOne?.let {
            options.add(it)
        }
        btnTwo?.let {
            options.add(it)
        }
        btnThree?.let{
            options.add(it)
        }
        btnFour?.let {
            options.add(it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_border_bg
            )
        }
    }

    private fun SelectedOptinView(tv:TextView, selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#5171E5"))
        tv.setTypeface(tv.typeface ,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_border_bg
        )
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_One->{
                btnOne?.let{
                    SelectedOptinView(it,1)
                }
            }
            R.id.btn_Two->{
                btnTwo?.let{
                    SelectedOptinView(it,2)
                }
            }
            R.id.btn_Three->{
                btnThree?.let{
                    SelectedOptinView(it,3)
                }
            }
            R.id.btn_Four->{
                btnFour?.let{
                    SelectedOptinView(it,4)
                }
            }
            R.id.btn_Submit->{
                if(mSelectedOptionPosition== 0){
                    mcurrentPosition++
                    when{
                        mcurrentPosition<=mquestionList!!.size->{
                            setQuestion()
                        }
                    }
                }
                else{
                    val question = mquestionList?.get(mcurrentPosition-1)
                    if(question!!.answer != mSelectedOptionPosition){
                        mSelectedOptionPosition?.let { answerView(it,R.drawable.wrong_answer) }
                    }
                    answerView(question.answer, R.drawable.correct_answer)

                    if(mcurrentPosition!= mquestionList!!.size){
                        submitButton?.text="Next Question"
                    }
                    else{
                        submitButton?.text="Result"
                    }
                }
                mSelectedOptionPosition =0
            }
        }
    }

    private fun answerView(answer:Int, drawableView: Int){
        when(answer){
            1-> btnOne?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )
            2-> btnTwo?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )
            3-> btnThree?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )
            4-> btnFour?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )
        }
    }
}