package com.example.sqlite2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNotaActivity : AppCompatActivity() {
    var myNotasDBHelper:NotasDBHelper? = null
    val DB_NAME= "notas.db"
    val DB_VERSION= 1
    var etTitulos: EditText?=null
    var etContenidos:EditText?= null
    var btnGuardarr:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)
        myNotasDBHelper= NotasDBHelper(this, DB_NAME,null,DB_VERSION)
        myNotasDBHelper!!.open()

        etTitulos = findViewById(R.id.etTitulo)
        etContenidos= findViewById(R.id.etContenido)
        btnGuardarr= findViewById(R.id.btnGuardar)

        btnGuardarr!!.setOnClickListener {

            val titulo = etTitulos!!.text.toString()
            val contenido = etContenidos!!.text.toString()

            myNotasDBHelper!!.addNota(titulo,contenido)

            etTitulos!!.setText("")
            etContenidos!!.setText("")
        }

    }
}