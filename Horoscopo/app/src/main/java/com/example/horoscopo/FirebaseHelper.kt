package com.example.horoscopo

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseHelper {
    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference

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
