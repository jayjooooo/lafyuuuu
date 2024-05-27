package com.example.lafyuu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dbHelper = DatabaseHelper(this)

        val editTextName: EditText = findViewById(R.id.editTextTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextTextEmail)
        val editTextPassword: EditText = findViewById(R.id.editTextTextPassword)
        val editTextPasswordAgain: EditText = findViewById(R.id.editTextTextPasswordAgain)
        val buttonSignUp: Button = findViewById(R.id.button)
        val textViewSignIn: TextView = findViewById(R.id.textViewSignIn)

        textViewSignIn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        buttonSignUp.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val passwordAgain = editTextPasswordAgain.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != passwordAgain) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                val id = dbHelper.addUser(name, email, password)
                if (id > 0) {
                    Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
