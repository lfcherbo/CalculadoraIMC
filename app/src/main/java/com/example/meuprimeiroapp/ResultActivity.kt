package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textviewResult)
        val tvClassification = findViewById<TextView>(R.id.textviewClassification)

        val result = intent.getFloatExtra("ExtraResult", 0.1f)

        tvResult.text = result.toString()

        val classification = if (result < 18.5f){
            "Abaixo do Peso"
        }else if (result in 18.5f..24.999f){
            "Peso Normal"
        }else if (result in 25.0f..29.999f){
            "Sobrepeso"
        }else if (result in 30.0f..39.999f){
            "Obesidade"
        }else {
            "Obesidade Grave"
        }

        tvClassification.text = getString(R.string.message_classification, classification)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}