package com.example.quizapp
object Constants {
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS : String = "total Questions"
    const val CORRECT_ANSWER :String = "Correct_answer"
    fun getQuestion(): ArrayList<Question>{
        val questionlist = ArrayList<Question>()
//        question 1
        val ques1 = Question(
            1, "What country does this flag belongs to ?",
            R.drawable.argentina_flag,
            "Argentina","India","America","Australia",
            1
        )
        questionlist.add(ques1)
//        question 2
        val ques2 = Question(
            2, "What country does this flag belongs to ?",
            R.drawable.indian_flag,
            "Argentina","India","America","Australia",
            2
        )
        questionlist.add(ques2)
//        question 3
        val ques3 = Question(
            3, "What country does this flag belongs to ?",
            R.drawable.pakistan_flag,
            "Argentina","India","America","Pakistan",
            4
        )
        questionlist.add(ques3)
//        question 4
        val ques4 = Question(
            4, "What country does this flag belongs to ?",
            R.drawable.china_flag,
            "China","India","America","Australia",
            1
        )
        questionlist.add(ques4)
//        question 5
        val ques5 = Question(
            5, "What country does this flag belongs to ?",
            R.drawable.australia_flag,
            "Argentina","India","America","Australia",
            4
        )
        questionlist.add(ques5)
//        question 6
        val ques6 = Question(
            6, "What country does this flag belongs to ?",
            R.drawable.america_flag,
            "Argentina","India","America","Australia",
            3
        )
        questionlist.add(ques6)
//        question 7
        val ques7 = Question(
            7, "What country does this flag belongs to ?",
            R.drawable.russia_flag,
            "Argentina","Russia","America","Australia",
            2
        )
        questionlist.add(ques7)
//        question 8
        val ques8 = Question(
            8, "What country does this flag belongs to ?",
            R.drawable.japan_flag,
            "Japan","India","America","Australia",
            1
        )
        questionlist.add(ques8)
//        question 9
        val ques9 = Question(
            9, "What country does this flag belongs to ?",
            R.drawable.isrial_flag,
            "Argentina","India","Isrial","Australia",
            3
        )
        questionlist.add(ques9)

        return questionlist
    }
}