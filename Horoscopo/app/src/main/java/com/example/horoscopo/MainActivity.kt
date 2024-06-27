package com.example.horoscopo

import android.os.Bundle
import android.text.TextPaint
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializar Firebase
        database = FirebaseDatabase.getInstance().reference

        val btn1: Button = findViewById(R.id.btn1)
        val signo: TextView = findViewById(R.id.signo)
        val opcion: TextView = findViewById(R.id.opcion)
        btn1.setOnClickListener {
            val opcionSeleccionada = opcion.text.toString().trim() // Eliminar espacios en blanco innecesarios
            if (opcionSeleccionada.isNotEmpty()) {
                val mensajePersonalizado = mensaje(opcionSeleccionada)
                signo.text = mensajePersonalizado
                guardarSignoEnFirebase(opcionSeleccionada, mensajePersonalizado)
            } else {
                // Si no se ingresa ninguna opción, mostrar un mensaje de error
                signo.text = "Debe ingresar un signo"
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun mensaje(opcion: String): String {
        return when (opcion.capitalize()) {
            "Piscis" -> "eeee"
            "Tauro" -> "ddddd"
            "Géminis" -> "ccccc"
            "Acuario" -> "bbbbbbb"
            "Virgo" -> "aaaaa"
            "Escorpio" -> "El mas fachero de todos"
            else -> {
                "Signo ingresado incorrecto o inexistente"
            }
        }
    }

    fun guardarSignoEnFirebase(opcion: String, mensaje: String) {
        val signoId = database.push().key // Crear un nuevo ID para la entrada
        val signoData = mapOf(
            "opcion" to opcion,
            "mensaje" to mensaje
        )

        if (signoId != null) {
            database.child("signos").child(signoId).setValue(signoData)
        }
    }
}