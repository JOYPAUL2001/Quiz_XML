package com.example.quizedemo

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestions(): ArrayList<Question>{


        val questionList = ArrayList<Question>()

        val q1 = Question(
            1, "What does this flag belong to?",
            R.drawable.uk, "India", "United Kingdom", "Russia", "Thailand", 2
        )
        val q2 = Question(
            2, "What does this flag belong to?",
            R.drawable.spain, "Spain", "United Kingdom", "USA", "China", 1
        )
        val q3 = Question(
            3, "What does this flag belong to?",
            R.drawable.portugal, "India", "Brazil", "Canada", "Portugal", 4
        )
        val q4 = Question(
            4, "What does this flag belong to?",
            R.drawable.bangladesh, "Bangladesh", "Pakistan", "Srilanka", "Afganisthan", 1
        )
        val q5 = Question(
            5, "What does this flag belong to?",
            R.drawable.pakistan, "India", "France", "Pakistan", "Russia", 3
        )
        val q6 = Question(
            6, "What does this flag belong to?",
            R.drawable.france, "Argentina", "France", "Germany", "Italy", 2
        )
        val q7 = Question(
            7, "What does this flag belong to?",
            R.drawable.brazil, "Brazil", "Peru", "Qatar", "India", 1
        )
        val q8 = Question(
            8, "What does this flag belong to?",
            R.drawable.usa, "India", "United Kingdom", "Russia", "USA", 4
        )
        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)

        return questionList
    }

}