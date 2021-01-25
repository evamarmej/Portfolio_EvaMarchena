package com.example.numerandom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGenera.setOnClickListener {
            val aleat = java.util.Random()
            val numAleat = aleat.nextInt(seekProg.progress + 1)
            textNumero.text = numAleat.toString()
        }
    }

}