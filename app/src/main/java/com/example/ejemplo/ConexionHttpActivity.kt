package com.example.ejemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import java.lang.Exception
import java.util.*
import com.github.kittinunf.result.Result.Failure
import com.github.kittinunf.result.Result.Success
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class ConexionHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)

        /*val json = """
        [
            {
                "usuariosDeEmpresa": [
                    {
                        "createdAt": 1561663617636,
                        "updatedAt": 1561663617636,
                        "id": 1,
                        "nombre": "Kevin",
                        "fkEmpresa": 1,
                    }
                ],
                "createdAt": 1561663617636,
                "updatedAt": 1561663617636,
                "id": 1,
                "nombre": "Manticore Labs"
            }
        ] */

        val json = """
        [
            {
                "usuariosDeEmpresa": [],
                "createdAt": 1561663617636,
                "updatedAt": 1561663617636,
                "id": 1,
                "nombre": "Manticore Labs"
            }
        ]
    """.trimIndent()

        try {
            val empresaInstancia = Klaxon()
                .parseArray<Empresa>(json)
            empresaInstancia?.forEach {
                Log.i("http",
                    "Nombre ${it.nombre}")

                Log.i("http",
                    "Id ${it.id}")

                Log.i("http",
                    "Fecha ${it.fechaCreacion}")

                it.usuariosDeEmpresa.forEach {
                    Log.i("http",
                        "Nombre ${it.nombre}")
                    Log.i("http",
                        "Fk ${it.fkEmpresa}")
                }

            }
        } catch (e:Exception){
            Log.i("hhhtp", "${e.message}")
            Log.i("http",
                "Error instanciando la empresa")
        }

        val url = "https://172.31.104.105:1337/empresa/1"

        url.
            httpGet().
            responseString { request, response, result ->
                when(result) {
                    is Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error ${ex.message}")
                    }
                    is Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        val empresaParseada = Klaxon().parse<Empresa>(data)
                        if(empresaParseada != null) {
                            Log.i("http", "${empresaParseada.nombre}")
                            Log.i("http", "${empresaParseada.id}")
                        }
                    }
                }
            }

        //Clase 04-07-2019

        val urlCrearEmpresa = "http://172.31.104.105:1337/empresa"

        val parametrosCrearEmpresa = listOf(
            "nombre" to "Manticore LABS 2",
            "apellido" to "Canacuan",
            "sueldo" to 12.25,
            "casado" to false,
            "hijos" to null
        )

        urlCrearEmpresa
            .httpPost(parametrosCrearEmpresa)
            .responseString { request, response, result ->
                when(result) {
                    is Failure -> {
                        val error = result.getException()
                        Log.i("http", "Error:: ${error}")
                    }
                    is Success -> {
                        val empresaString = result.get();
                        Log.i("http", "${empresaString}")
                    }
                }
            }

    }




}
