package com.example.assignmentproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        val welcomeButton = findViewById<Button>(R.id.button)

        // trying to make the sun smile, image is off and is turned on by the continue button
        val sunSmile = findViewById<ImageView>(R.id.imageGlasses)

        welcomeButton.setOnClickListener {

            sunSmile.visibility = View.VISIBLE  //turning the image on


           //first waits 1.5 seconds
            welcomeButton.postDelayed({

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            },1500) //then moves on to next activity

        }
    }
}