package com.example.tictactoeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected: Button = view as Button
        var cellId = 0
        when (buSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9

        }
        //  Log.d("buclick:", buSelected.id.toString())
        //  Log.d("buclick: cellId", cellId.toString())
        playGame(cellId, buSelected)

    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playGame(cellId: Int, buSelected: Button?) {
        if (activePlayer == 1) {
            buSelected.text = "x"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        } else {
            buSelected.text = "0"
            buSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }
        if(winner == 1){
            Toast.makeText(this, "Player  1 win the game", Toast.LENGTH_LONG).show()
        }
        else if(winner ==2){
            Toast.makeText(this, "Player  2 win the game", Toast.LENGTH_LONG).show()
        }

    }
    fun autoPlay(){
        var emptyCells = ArrayList<Int>()
        for(cellId in 1..9){
            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        val r = Random()
        var randIndex = r.nextInt(emptyCells.size)
        var cellId: Int = emptyCells[randIndex]
        val buSelected: Button?
        buSelected = when(cellId){
            1-> {button1}
            2-> {button2}
            3-> {button3}
            4-> {button4}
            5-> {button5}
            6-> {button6}
            7-> {button7}
            8-> {button8}
            9-> {button9}
            else-> {button1}
        }
        playGame(cellId, buSelected)

    }

}


