package com.example.ejemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_primero.setOnClickListener {
            abrirPrimerFragmento()
        }

        btn_segundo.setOnClickListener {
            abrirSegundoFragmento()
        }
    }

    fun abrirPrimerFragmento(){
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la transaccion
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val primerFragmento = PrimerFragment()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, primerFragmento)
        // 5) terminar la transaccion
        transaccion.commit()
    }

    fun abrirSegundoFragmento(){
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la transaccion
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val segundoFragment = SegundoFragment()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, segundoFragment)
        // 5) terminar la transaccion
        transaccion.commit()
    }




}
