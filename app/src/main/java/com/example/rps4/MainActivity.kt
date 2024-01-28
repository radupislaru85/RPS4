package com.example.rps4
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var imgRock: ImageView
    private lateinit var imgPaper: ImageView
    private lateinit var imgScissors: ImageView
    private lateinit var tvResult: TextView
    private lateinit var scoreTextView: TextView

    private var userScore = 0
    private var computerScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgRock = findViewById(R.id.imgRock)
        imgPaper = findViewById(R.id.imgPaper)
        imgScissors = findViewById(R.id.imgScissors)
        tvResult = findViewById(R.id.tvResult)
        scoreTextView = findViewById(R.id.scoreTextView)
    }

    fun onImageClick(view: View) {
        when (view.id) {
            R.id.imgRock -> playGame("Rock")
            R.id.imgPaper -> playGame("Paper")
            R.id.imgScissors -> playGame("Scissors")
        }
    }

    private fun playGame(userChoice: String) {
        val choices = arrayOf("Rock", "Paper", "Scissors")
        val randomIndex = Random.nextInt(choices.size)
        val computerChoice = choices[randomIndex]

        // Compare userChoice with computerChoice to determine the winner
        val result: String = when {
            userChoice == computerChoice -> "It's a draw!"
            (userChoice == "Rock" && computerChoice == "Scissors") ||
                    (userChoice == "Paper" && computerChoice == "Rock") ||
                    (userChoice == "Scissors" && computerChoice == "Paper") -> {
                userScore++
                "You win!"
            }
            else -> {
                computerScore++
                "Computer wins!"
            }
        }

        // Update TextViews to display the result and score
        tvResult.text = "YOU: $userChoice\nCPU: $computerChoice\n$result"
        scoreTextView.text = "Score: You $userScore, Computer $computerScore"
    }
}
