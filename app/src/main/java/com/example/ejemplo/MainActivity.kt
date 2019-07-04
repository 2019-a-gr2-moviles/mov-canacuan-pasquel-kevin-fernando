package com.example.ejemplo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad__dos.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_actividad_dos.setOnClickListener {
            irActividadDos()
        }

        btn_actividadhttp.setOnClickListener {
            irActividadHttp()
        }

        btn_mapa.setOnClickListener {
            irActividadMapa()
        }
    }

    fun irActividadMapa() {
        val intentExplicito = Intent (
            this,
            MapsActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irActividadDos() {
        val intent = Intent(
            this,
            Actividad_Dos::class.java
        )

        intent.putExtra("nombre", "Kevin")
        intent.putExtra("edad", 24)
        startActivity(intent)
    }

    fun irActividadHttp() {
        val intentExplicito = Intent (
            this,
            ConexionHttpActivity::class.java
        )
        startActivity(intentExplicito)
    }

}


