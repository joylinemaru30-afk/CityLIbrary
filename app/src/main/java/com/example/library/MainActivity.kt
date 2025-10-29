package com.example.library

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
        //endListener

        //find the textview by use of an id
        val UsernameTextview=findViewById<TextView>(R.id.tvUsername)
        //get the stored username returned from the API
        val prefs=getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val username=prefs.getString("username","user")
        //bind to the textview
        UsernameTextview.text="Welcome $username"


    }
}