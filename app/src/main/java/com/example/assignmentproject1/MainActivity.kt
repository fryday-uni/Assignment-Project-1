package com.example.assignmentproject1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    enum class Time {
        MORNING,
        MID_MORNING,
        AFTERNOON,
        AFTERNOON_SNACK_TIME,
        DINNER,
        AFTER_DINNER,
        NIGHT,
        EVENING,
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaring the variables and connecting them to respective buttons
        val currentTime = findViewById<EditText>(R.id.timeEditText)
        val sparkResult = findViewById<TextView>(R.id.resultView)
        val printTextView = findViewById<ImageButton>(R.id.sparkButton)
        val clearButton = findViewById<ImageButton>(R.id.clearButton)

        printTextView.setOnClickListener {
            // user input of time set to uppercase to make it not case-sensitive
            val timeInput = currentTime.text.toString().uppercase()

            val timeInputIsNumber = timeInput.toIntOrNull()

            if (timeInputIsNumber == null ) {
                // if time input is a string it'll be null since it cant turn into an int


                // changing this  string into enum value,adapted with assistance from ChatGPT (OpenAI), 2026
                val time = try {
                    Time.valueOf(timeInput)
                } catch (e: Exception) {
                    null
                }

                //sets the spark suggestion depending on time
                val sparkSuggestion = when (time) {
                    Time.MORNING -> "Send a good morning text to a family member. "
                    Time.MID_MORNING -> "Reach out to a colleague with a quick thank you"
                    Time.AFTERNOON -> "Share a funny meme or interesting link with a friend"
                    Time.AFTERNOON_SNACK_TIME -> "send a quick 'thinking of you' message"
                    Time.DINNER, Time.EVENING -> "call a friend or relative for a 5-minute catchup"
                    Time.AFTER_DINNER, Time.NIGHT -> "Leave a thoughtful comment on a friends's post"
                    else -> "Please spell correctly, or put _ instead of space, if you using :00 format, just enter the hour "
                }

                sparkResult.text = sparkSuggestion

            }
                //if it's a number instead it'll be between these ranges and the phrase is equal to it
           else { val sparkSuggestion = when (timeInputIsNumber) {
                in 0..8 -> "Send a good morning text to a family member. "
                in 9..12 -> "Reach out to a colleague with a quick thank you"
                in 13..15 -> "Share a funny meme or interesting link with a friend"
                in 16..18 -> "send a quick 'thinking of you' message"
                in 19..20 -> "call a friend or relative for a 5-minute catchup"
                in 20..23 -> "Leave a thoughtful comment on a friends's post"
                else -> "please don't use :00 time format, just enter the hour "

            }

                sparkResult.text = sparkSuggestion

           }

        }

        //makes the button clear both texts
        clearButton.setOnClickListener {
            sparkResult.text = ""
            currentTime.text.clear()

        }

    }
}

