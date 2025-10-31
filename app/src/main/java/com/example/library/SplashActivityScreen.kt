package com.example.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivityScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        // Find views
        val logo1 = findViewById<ImageView>(R.id.image)


        // Load animations
        val animLogo1 = AnimationUtils.loadAnimation(this, R.anim.splash)


        // Start animations
        logo1.startAnimation(animLogo1)


        // Move to MainActivity after 5 seconds
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Close splash so user cannot return to it
        }, 5000)
    }
}