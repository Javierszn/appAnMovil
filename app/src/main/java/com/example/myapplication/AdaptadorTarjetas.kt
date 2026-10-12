package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorTarjetas(context: Context, private val actividades: Array<String>) :
    ArrayAdapter<String>(context, 0, actividades) {
    private val selecciones = BooleanArray(actividades.size)
    fun cambiarSeleccion(posicion: Int) {
        selecciones[posicion] = !selecciones[posicion]
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_actividad_tarjeta, parent, false)

        val tvTitulo = view.findViewById<TextView>(R.id.tvTituloActividad)
        val tvSubtitulo = view.findViewById<TextView>(R.id.tvSubtituloActividad)
        val ivPalomita = view.findViewById<ImageView>(R.id.ivPalomita)

        val tarjeta = view.findViewById<androidx.cardview.widget.CardView>(R.id.cvTarjetaFondo)

        tvTitulo.text = actividades[position]

        if (selecciones[position]) {
            tvSubtitulo.visibility = View.VISIBLE
            ivPalomita.visibility = View.VISIBLE
            tarjeta.setCardBackgroundColor(android.graphics.Color.parseColor("#E0E0E0")) // Color GRIS al seleccionar
        } else {
            tvSubtitulo.visibility = View.GONE
            ivPalomita.visibility = View.INVISIBLE
            tarjeta.setCardBackgroundColor(android.graphics.Color.parseColor("#D5F5E3")) // Color VERDE original
        }

        return view
    }
}