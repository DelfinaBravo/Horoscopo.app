package com.example.pruebafirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn1 : Button = findViewById(R.id.btn1)
        val email : TextView = findViewById(R.id.email)
        val password : TextView = findViewById(R.id.password)
        firebaseAuth = Firebase.auth
        btn1.setOnClickListener(){
            signIn(email.text.toString(), password.text.toString())
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun signIn(email: String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ task ->
                //en caso de que los datos ingresados sean correctos
                if(task.isSuccessful){
                    //toma los datos de usuario
                    val user = firebaseAuth.currentUser
                    //-------------------------variables para obtener el uid de usuario de firebase
                    Toast.makeText(baseContext,"Autenticacion exitosa", Toast.LENGTH_SHORT).show()
                    //aqui vamos a ir a la segunda activity
                    val i = Intent(this, MainActivity2::class.java)
                    startActivity(i)
                }
                else {
                    Toast.makeText(baseContext,"Error. Email y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()

                }
        }
    }
}