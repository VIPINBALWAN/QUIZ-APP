package com.example.quizapp

class GetAllQuestions {

    fun fetchData(): ArrayList<Questions> {
        val allQuestions = ArrayList<Questions>()
        val q1 = Questions(
            1,
            "What is 5 + 3?",
            "6",
            "7",
            "8",
            "9",
            3
        )
        val q2 = Questions(
            2,
            "What is 9 - 4?",
            "3",
            "5",
            "6",
            "7",
            2
        )
        val q3 = Questions(
            3,
            "What is 2 × 3?",
            "5",
            "6",
            "7",
            "8",
            2
        )
        val q4 = Questions(
            4,
            "How many apples are there in a group of 4 apples and 3 apples?",
            "5",
            "6",
            "7",
            "8",
            3
        )
        val q5 = Questions(
            5,
            "Which number is greater, 7 or 5?",
            "5",
            "7",
            "They are equal",
            "None",
            2
        )
        val q6 = Questions(
            6,
            "How many sides does a triangle have?",
            "2",
            "3",
            "4",
            "5",
            2
        )
        val q7 = Questions(
            7,
            "If it's 2 PM now, what time will it be in 3 hours?",
            "4 PM",
            "5 PM",
            "6 PM",
            "7 PM",
            3
        )
        val q8 = Questions(
            8,
            "Is the number 8 even or odd?",
            "Even",
            "Odd",
            "Neither",
            "Both",
            1
        )
        val q9 = Questions(
            9,
            "How many cents are there in 2 dimes?",
            "10",
            "20",
            "25",
            "30",
            2
        )
        val q10 = Questions(
            10,
            "What day comes after Tuesday?",
            "Monday",
            "Wednesday",
            "Thursday",
            "Friday",
            2
        )
        allQuestions.add(q1)
        allQuestions.add(q2)
        allQuestions.add(q3)
        allQuestions.add(q4)
        allQuestions.add(q5)
        allQuestions.add(q6)
        allQuestions.add(q7)
        allQuestions.add(q8)
        allQuestions.add(q9)
        allQuestions.add(q10)

        return allQuestions
    }
}
