package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        // show results of roll on screen
        val coinImage: ImageView = findViewById(R.id.imageView2)
        val drawableResource2 = when (coinFlip){
            1 -> (R.drawable.heads_flip)
            else-> (R.drawable.tails_flip)
        }

        coinImage.setImageResource(drawableResource2)

    }

    private fun rollDice() {
        // create dice with 6 sides and  calls roll on dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // show results of roll on screen
        val diceImage : ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll){
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else-> (R.drawable.dice_6)
        }
        diceImage.setImageResource(drawableResource)

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