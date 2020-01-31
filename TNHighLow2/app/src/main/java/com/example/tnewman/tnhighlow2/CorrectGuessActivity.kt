package com.example.tnewman.tnhighlow2
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_correct_guess.*

import java.util.*

class CorrectGuessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correct_guess)

        playAgain()
        exitGame()
    }

    fun playAgain() {
        btnAgain.setOnClickListener {
            val intent = Intent("com.example.tnewman.tnhighlow2.MainActivity")
            startActivity(intent)
        }
    }

    fun exitGame() {
        btnExit.setOnClickListener {
            this.finishAffinity()
        }

    }
}


