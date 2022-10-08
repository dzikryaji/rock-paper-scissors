package com.example.rock_paper_scissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    private val optionsDrawableComputer = mapOf(
        "ROCK" to R.drawable.rock_computer,
        "PAPER" to R.drawable.paper_computer,
        "SCISSORS" to R.drawable.scissors_computer
    )

    private fun randomPicker() = options[Random.nextInt(0,3)]

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
        rockImageButton.setOnClickListener {
            userImageView.setImageResource(R.drawable.rock)
            startGame("ROCK")
        }
        paperImageButton.setOnClickListener {
            userImageView.setImageResource(R.drawable.paper)
            startGame("PAPER")
        }
        scissorsImageButton.setOnClickListener {
            userImageView.setImageResource(R.drawable.scissors)
            startGame("SCISSORS")
        }
    }

    private fun startGame(userPick: String){
        val computerPick = randomPicker()
        computerImageView.setImageResource(pickDrawableComputer(computerPick))

        if (isDraw(userPick, computerPick)){
            Log.i("GAME", "draw")
            resultImageView.setImageResource(R.drawable.draw)
        }else if (isWin(userPick, computerPick)){
            Log.i("GAME", "win")
            resultImageView.setImageResource(R.drawable.win)
        } else{
            Log.i("GAME", "lose")
            resultImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initListener()

    }
}