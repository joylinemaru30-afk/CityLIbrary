package com.example.library

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //find the textview by use of an id
        val UsernameTextview=findViewById<TextView>(R.id.tvUsername)
        //get the stored username returned from the API
        val prefs=getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val username=prefs.getString("username","user")
        //bind to the textview
        UsernameTextview.text="Welcome $username"

        //find the progress bar and the recyler Bin by use of their ids
        val progressBar=findViewById<ProgressBar>(R.id.progressbar)
        val recylerView=findViewById<RecyclerView>(R.id.recylerView)

        //define your url where you are fetching the products
        val url="https://joykosgei.pythonanywhere.com/api/getproducts"
        //import the helper
        val helper=ApiHelper(applicationContext)

        //we have the function called load products which reqiures three parameters
        helper.loadProducts(url,recylerView,progressBar)

        //find the sell button
        val buttonsell=findViewById<Button>(R.id.btnSell)

        buttonsell.setOnClickListener {
            val sellpage=Intent(Intent.ACTION_VIEW, Uri.parse("https://sokogarden-theta.vercel.app/addproduct"))
            startActivity(sellpage)
        }

    }
}