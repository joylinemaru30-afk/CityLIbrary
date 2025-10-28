package com.example.library

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.loopj.android.http.RequestParams

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        // Find the four edit texts and one button by use of their ids
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val phone = findViewById<EditText>(R.id.phone)
        val username = findViewById<EditText>(R.id.username)
        val signupButton = findViewById<Button>(R.id.signup)

        signupButton.setOnClickListener {
            // Get user input
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()
            val phoneText = phone.text.toString().trim()
            val usernameText = username.text.toString().trim()

            // Validate inputs before sending
            if (emailText.isEmpty() || passwordText.isEmpty() || phoneText.isEmpty() || usernameText.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Optionally: validate email format
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // specify the API
            val api = "https://joykosgei.pythonanywhere.com/api/signup"

            // Add data to RequestParams
            val data = RequestParams()
            data.put("email", emailText)
            data.put("password", passwordText)
            data.put("phone", phoneText)
            data.put("username", usernameText)

            // Access the helper and post method to push the data
            val helper = ApiHelper(applicationContext)
            helper.post(api, data)
        }
    }
}
