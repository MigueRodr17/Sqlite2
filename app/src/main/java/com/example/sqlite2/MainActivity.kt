package com.example.sqlite2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var myNotasDBHelper:NotasDBHelper?=null
    val DB_NAME = "notas.db"
    val DB_VERSION = 1

    var fabAdd:FloatingActionButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAdd = findViewById(R.id.FABAddNota)

        myNotasDBHelper= NotasDBHelper(this, DB_NAME,null,DB_VERSION)
        myNotasDBHelper!!.open()


        fabAdd!!.setOnClickListener {
            val i = Intent(this,AddNotaActivity::class.java)
            startActivity(i)

        }

    }
}