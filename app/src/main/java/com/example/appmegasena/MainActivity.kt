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

        // reconhecer todos os componentes atraves do id
        val textViewN1 = findViewById<TextView>(R.id.textViewN1)
        val textViewN2 = findViewById<TextView>(R.id.textViewN2)
        val textViewN3 = findViewById<TextView>(R.id.textViewN3)
        val textViewN4 = findViewById<TextView>(R.id.textViewN4)
        val textViewN5 = findViewById<TextView>(R.id.textViewN5)
        val textViewN6 = findViewById<TextView>(R.id.textViewN6)

        val btnJogar = findViewById<Button>(R.id.btnJogar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        // setar um evento click no botao
        btnJogar.setOnClickListener{
            // armazena a lista gerada pela função numerosAleatorios
            val numerosSorteados = numerosAleatorios()

            // atribui o valor de cada indice da lista à variavel de cada textView
            textViewN1.text = numerosSorteados[0].toString()
            textViewN2.text = numerosSorteados[1].toString()
            textViewN3.text = numerosSorteados[2].toString()
            textViewN4.text = numerosSorteados[3].toString()
            textViewN5.text = numerosSorteados[4].toString()
            textViewN6.text = numerosSorteados[5].toString()

            // mostra uma mensagem para o usuario
            Toast.makeText(this, "Números Sorteados!!", Toast.LENGTH_LONG).show()

            // bloqueia o tap do botao
            btnJogar.isClickable = false
        }

        // setar um evento click no botao
        btnLimpar.setOnClickListener{
            //limpa todos os valores dos textViews
            textViewN1.text = ""
            textViewN2.text = ""
            textViewN3.text = ""
            textViewN4.text = ""
            textViewN5.text = ""
            textViewN6.text = ""

            // libera o tap do botao
            btnJogar.isClickable = true
        }
    }

    //função para gerar uma lista de numeros aleatorios
    private fun numerosAleatorios(): List<Int>{
        //gera um array mutavel
        val numerosAleatorios = mutableListOf<Int>()

        // looping para atribuir valores à lista até que ela esteja com 6 valores
        while(numerosAleatorios.size < 6){

            // sorteia um numero de 1 a 60
            val numeroAleatorio = Random.nextInt(1, 61)

            //valida se o numero já se encontra na lista
            if(!numerosAleatorios.contains(numeroAleatorio)){
                // adiciona o numero na lista se ele nao se encontrar nela
                numerosAleatorios.add(numeroAleatorio)
            }
        }
        // retorna a lista gerada
        return numerosAleatorios
    }
}