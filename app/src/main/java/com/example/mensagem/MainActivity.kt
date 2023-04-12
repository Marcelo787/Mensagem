package com.example.mensagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val EXTRA_MENSAGEM = "mensagem"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonEnviar = findViewById<Button>(R.id.buttonEnviar)
        buttonEnviar.setOnClickListener {

            enviaMensagem()
        }
    }

    fun enviaMensagem() {
        //Toast.makeText(this, "enviar mensagem", Toast.LENGTH_SHORT).show()
        val editTextMensagem = findViewById<EditText>(R.id.editTextTextMensagem)
        val mensagem = editTextMensagem.text.toString()

        if(mensagem.isBlank()){
            editTextMensagem.error = getString(R.string.mensagem_vazia)
            editTextMensagem.requestFocus()

            return
        }

        val intent = Intent(this, MostrarMensagemActivity::class.java)
        intent.putExtra(EXTRA_MENSAGEM,mensagem)
        // CTRL + ALT L C CREATE CONSTANT "EXTRA_MENSAGEM"
        startActivity(intent)
    }
}