package com.example.assignmentproject1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val printTextView = findViewById<Button>(R.id.sparkButton)
        val clearButton = findViewById<Button>(R.id.clearButton)


        printTextView.setOnClickListener {
            // user input of time set to uppercase to make it not case-sensitive
            val timeInput = currentTime.text.toString().uppercase()

            // changing this stupid string into enum value, stole from ChatGPT
            val time = try {
                Time.valueOf(timeInput)
            } catch (e: Exception) {
                null
            }

            //sets the spark suggestion depending on time
            val sparkSuggestion = when(time) {
                Time.MORNING -> "Send a good morning text to a family member. "
                Time.MID_MORNING -> "Reach out to a colleague with a quick thank you"
                Time.AFTERNOON -> "Share a funny meme or interesting link with a friend"
                Time.AFTERNOON_SNACK_TIME -> "send a quick 'thinking of you' message"
                Time.DINNER,Time.EVENING -> "call a friend or relative for a 5-minute catchup"
                Time.AFTER_DINNER,Time.NIGHT -> "Leave a thoughtful comment on a friends's post"
                else -> "Please put _ instead of space "
            }

            sparkResult.text = sparkSuggestion

        }
        //makes the button clear both
        clearButton.setOnClickListener {
            sparkResult.text = ""
            currentTime.text.clear()


        }

    }
}