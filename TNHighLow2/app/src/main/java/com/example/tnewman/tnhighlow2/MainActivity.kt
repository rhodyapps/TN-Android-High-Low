package com.example.tnewman.tnhighlow2
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import org.jetbrains.anko.toast
// added to support the addition of the toast code

import kotlinx.android.synthetic.main.activity_main.*

import org.jetbrains.anko.toast // added to support the addition of the toast code


class MainActivity : AppCompatActivity() {

    var randomNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandomNumber()
        createListenerForButton()
    }

    fun generateRandomNumber(): Int {

        var random = Random()
        var min = 1
        var max = 10
        randomNum = random.nextInt(max + 1 - min) + min
// note: Kotlin does not use the 'new' keyword for the randomNum
        return randomNum

    }

    fun assignRandomNumber() {
        randomNum = generateRandomNumber()

    }

    fun guessNumber() {

        var numberToGuess = randomNum
        var userGuess: Int = Integer.parseInt(numGuess.getText().toString())

// note that we are turning the number into a string for user input/output and then back to an integer
        // similar to what we did with the C++ program

        checkUserGuess(userGuess, numberToGuess)
    }

    fun checkUserGuess(userGuess: Int, numberToGuess: Int) {
        if (userGuess > numberToGuess) {
            lblFeedback.setText("Lower")
        } else if (userGuess > numberToGuess) {
            lblFeedback.setText("Higher")
        } else {
            lblFeedback.setText("Correct!")

            openCorrectGuessScreen()

        }
    }

    fun createListenerForButton() {
        // btnGuess.setOnClickListener{
        //    guessNumber()

        // this code was added to check if the user enters a number, you need to add an import
        // statement to the beginning of the program: import org.jetbrains.anko.toast

        btnGuess.setOnClickListener {
            if (numGuess.getText().toString().equals("")) {
                toast("Please enter a number")
            } else {
                guessNumber()
            }
        }
    }

    fun openCorrectGuessScreen() {

/* Example code from the book

            val intent = Intent("com.example.michael.higherorlower.CorrectGuessActivity")
            startActivity(intent)
            */

        /* Code adapted to the current project */
       val intent = Intent("com.example.tnewman.tnhighlow2.CorrectGuessActivity")
           startActivity(intent)

         /* build errors:
         Error:(94, 23) Unresolved reference: Intent
         Error:(94, 61) Classifier 'CorrectGuessActivity' does not have a companion object, and thus must be initialized here
This error goes away if you put the activity name in quotes

This code was throwing the unresolved reference: Intent error until I added
import android.content.Intent to the top of the MainActivity, also have to add
import android.content.Intent to the CorrectGuessActivity or you will get the same error.


          */



        }

    }
