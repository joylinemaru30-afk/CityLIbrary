package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.loopj.android.http.RequestParams

class MakePayment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_payment)
        //receive the retrive the data put on the extra
        val name =intent.getStringExtra("Product_name")
        val cost=intent.getIntExtra("product_cost",0)
        val productPhoto=intent.getStringExtra("product_photo")

        //find the textviews inside of the makepayment activity and replace the data
        val txtname=findViewById<TextView>(R.id.txtProductName)
        val txtcost=findViewById<TextView>(R.id.txtProductCost)
        val imgproduct=findViewById<ImageView>(R.id.imgproduct)
        //update the textviews with the values passed via the intent
        txtname.text=name
        txtcost.text="kes $cost"
        val imageUrl = "https://joykosgei.pythonanywhere.com/static/images/$productPhoto"

        //Load image using Glide, Load Faster with Glide
        Glide.with(this)
            .load(imageUrl )
            .placeholder(R.drawable.ic_launcher_background) // Make sure you have a placeholder image
            .into(imgproduct)

        //`find the edit text and the button by use of the ids
        val btnpay=findViewById<Button>(R.id.pay)
        val editphone=findViewById<EditText>(R.id.phone)

        //set a click listener to the button
        btnpay.setOnClickListener {
            //specify the api endpoint
            val api ="https://joykosgei.pythonanywhere.com/api/mpesa_payment"
            //get phone number
            val phone=editphone.text.toString().trim()
            //create a requestparams
            val data =RequestParams()

            //put data into the requestparams
            data.put("amount",cost)
            data.put("phone",phone)

            //import the APIhelper
            val helper=ApiHelper(applicationContext)

            //access the post method/function inside the helper class
            helper .post(api,data)
        }

    }
}