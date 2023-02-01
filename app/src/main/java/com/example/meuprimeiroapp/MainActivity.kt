package com.example.meuprimeiroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalculation: Button = findViewById<Button>(R.id.btncalculation)
        val edtPeso : EditText = findViewById(R.id.edtMsg_peso)
        val edtAltura : EditText = findViewById(R.id.edtMsg_altura)

        btnCalculation.setOnClickListener{

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                val altura : Float = edtAltura.text.toString().toFloat()
                val alturaFinal: Float = altura * altura
                val peso: Float = edtPeso.text.toString().toFloat()
                val result: Float= peso / alturaFinal

                val intent = Intent( this, ResultActivity::class.java)
                .apply {
                    putExtra("ExtraResult", result)
                }
                startActivity(intent)

            }else {
                Toast.makeText(this,"Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}