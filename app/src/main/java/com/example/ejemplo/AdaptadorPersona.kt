package com.example.ejemplo

import  android.support.v7.widget.RecyclerView;

class AdaptadorPersona(
    private val listaPersonas: List<Persona>,
    private val contexto: ReciclerViewActivity,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>() {
}