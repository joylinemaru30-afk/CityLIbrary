package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.loopj.android.http.RequestParams

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singin)
        //find the two edits texts and button by use of their ids
        val email =findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)
        val signinbutton=findViewById<Button>(R.id.signin)

        //set onclick listener in the button
        signinbutton.setOnClickListener {
            //specify the API endpoint
            val api="https://joykosgei.pythonanywhere.com/api/signin"
            //add texts from the EditTexts to the request params,email and the password
            val data =RequestParams()
            //add the two (emails,passwords)
            data.put("email",email.text.toString().trim())
            data.put("password",password.text.toString().trim())
            //access the helper and use the post method to push the data through the API end point
            val helper=ApiHelper(application)
            helper.post_login(api,data)
        }
    }
}