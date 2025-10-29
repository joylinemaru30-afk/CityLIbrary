package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        //find the progress bar and the recyler Bin by use of their ids
        val progressBar=findViewById<ProgressBar>(R.id.progressbar)
        val recylerView=findViewById<RecyclerView>(R.id.recylerView)

        //define your url where you are fetching the products
        val url="https://joykosgei.pythonanywhere.com/api/getproducts"
        //import the helper
        val helper=ApiHelper(applicationContext)

        //we have the function called load products which reqiures three parameters
        helper.loadProducts(url,recylerView,progressBar)

    }
}