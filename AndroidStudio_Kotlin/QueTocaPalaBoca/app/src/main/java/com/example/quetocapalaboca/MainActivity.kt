package com.example.quetocapalaboca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listaPlatos = arrayListOf("Serranito", "Hamburguesa", "Perrito", "Pizza", "Montadito", "Brocheta")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botDecidir.setOnClickListener {
            val aleat = java.util.Random()
            val platoAleat = aleat.nextInt(listaPlatos.count())
            quesepedira.text = listaPlatos[platoAleat]
        }

        botPlato.setOnClickListener{
            val nuevoPlato = teclePlato.text.toString()
            listaPlatos.add(nuevoPlato)
            teclePlato.text.clear()
        }
    }
}