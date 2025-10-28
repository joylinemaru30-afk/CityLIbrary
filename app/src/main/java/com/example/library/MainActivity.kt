package com.example.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sing_button= findViewById<Button>(R.id.signin)
        sing_button.setOnClickListener {
            val signin =Intent (applicationContext,Signin::class.java)
            startActivity(signin)

        }
        val signup=findViewById<Button>(R.id.signup)
        signup.setOnClickListener {
            val signup=Intent(applicationContext,Signup::class.java)
            startActivity(signup)
        }


    }
}