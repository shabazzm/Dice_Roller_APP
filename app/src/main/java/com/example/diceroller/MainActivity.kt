package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        val rollButton2: Button = findViewById(R.id.button2)
        rollButton2.setOnClickListener { flipCoin() }
    }

    private fun flipCoin() {
        val coin = Coin()
        val coinFlip = coin.flip()
        val headsText = "Heads"
        val tailsText = "Tails"
        val resultTextView2: TextView = findViewById(R.id.textView2)
        if (coinFlip == 1) {
            resultTextView2.text = headsText
        } else {
            resultTextView2.text = tailsText
        }

    }

    private fun rollDice() {
        // create dice with 6 sides and  calls roll on dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // show results of roll on screen
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }


}

class Dice(private val numSides: Int) {
    //rolls dice and produces number in range of 1 and number passed in
    fun roll(): Int {
        return (1..numSides).random()
    }
}

class Coin() {
    // flips coin either 1 heads or 0 tail
    fun flip(): Int {
        return (0..1).random()
    }
}