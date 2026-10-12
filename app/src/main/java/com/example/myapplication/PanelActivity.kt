package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {

    private val misActividades = arrayOf(
        "Pasos Diarios",
        "Natación",
        "Rutina de Fuerza",
        "Sesión de Box",
        "Desayuno",
        "Comida"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        // Configurar botón regresar
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            finish() // Esto cierra esta pantalla y te regresa a la anterior
        }

        // Mostrar los pasos
        val tvPasosEnPanel = findViewById<TextView>(R.id.tvPasosEnPanel)
        val pasosRecibidos = intent.getIntExtra("PASOS", 0)
        tvPasosEnPanel.text = pasosRecibidos.toString() // Solo el número, sin repetir texto

        // Configurar la lista
        val lvActividades = findViewById<ListView>(R.id.lvActividades)
        val adaptadorPersonalizado = AdaptadorTarjetas(this, misActividades)
        lvActividades.adapter = adaptadorPersonalizado

        lvActividades.setOnItemClickListener { _, _, position, _ ->
            adaptadorPersonalizado.cambiarSeleccion(position)

            val actividadTocada = misActividades[position]
            Toast.makeText(this, "¡Completaste: $actividadTocada!", Toast.LENGTH_SHORT).show()
        }
    }
}