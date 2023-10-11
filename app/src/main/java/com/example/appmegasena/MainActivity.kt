package com.example.appmegasena

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewN1 = findViewById<TextView>(R.id.textViewN1)
        val textViewN2 = findViewById<TextView>(R.id.textViewN2)
        val textViewN3 = findViewById<TextView>(R.id.textViewN3)
        val textViewN4 = findViewById<TextView>(R.id.textViewN4)
        val textViewN5 = findViewById<TextView>(R.id.textViewN5)
        val textViewN6 = findViewById<TextView>(R.id.textViewN6)

        val btnJogar = findViewById<Button>(R.id.btnJogar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnJogar.setOnClickListener{
            val numerosSorteados = numerosAleatorios()


            textViewN1.text = numerosSorteados[0].toString()
            textViewN2.text = numerosSorteados[1].toString()
            textViewN3.text = numerosSorteados[2].toString()
            textViewN4.text = numerosSorteados[3].toString()
            textViewN5.text = numerosSorteados[4].toString()
            textViewN6.text = numerosSorteados[5].toString()

            Toast.makeText(this, "Números Sorteados!!", Toast.LENGTH_LONG).show()

            btnJogar.isClickable = false
        }

        btnLimpar.setOnClickListener{
            textViewN1.text = ""
            textViewN2.text = ""
            textViewN3.text = ""
            textViewN4.text = ""
            textViewN5.text = ""
            textViewN6.text = ""

            btnJogar.isClickable = true
        }
    }

    private fun numerosAleatorios(): List<Int>{
        val numerosAleatorios = mutableListOf<Int>()

        while(numerosAleatorios.size < 6){
            val numeroAleatorio = Random.nextInt(1, 61)
            if(!numerosAleatorios.contains(numeroAleatorio)){
                numerosAleatorios.add(numeroAleatorio)
            }
        }

        return numerosAleatorios
    }
}