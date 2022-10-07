package com.example.rock_paper_scissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var computerImageView : ImageView
    private lateinit var userImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private val options = listOf("ROCK", "PAPER", "SCISSORS")

    private val rules = mapOf(
        "ROCK-SCISSORS" to true,
        "PAPER-ROCK" to true,
        "SCISSORS-PAPER" to true,
        "ROCK-PAPER" to false,
        "PAPER-SCISSORS" to false,
        "SCISSORS-ROCK" to false,
    )

    private val optionsDrawable = mapOf(
        "ROCK" to R.drawable.rock,
        "PAPER" to R.drawable.paper,
        "SCISSORS" to R.drawable.scissors
    )

    private val optionsDrawableComputer = mapOf(
        "ROCK" to R.drawable.rock_computer,
        "PAPER" to R.drawable.paper_computer,
        "SCISSORS" to R.drawable.scissors_computer
    )

    private fun randomPicker() = options[Random.nextInt(0,3)]

    private fun pickDrawable(option : String): Int = optionsDrawable[option]!!

    private fun pickDrawableComputer(option : String): Int = optionsDrawableComputer[option]!!

    private fun isDraw(user: String, computer: String): Boolean = user == computer

    private fun isWin(user: String, computer: String): Boolean = rules["$user-$computer"]!!

    private fun initComponent(){
        computerImageView = findViewById(R.id.computerImageView)
        userImageView = findViewById(R.id.userImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListener(){
        rockImageButton.setOnClickListener {  }
        paperImageButton.setOnClickListener {  }
        scissorsImageButton.setOnClickListener {  }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}