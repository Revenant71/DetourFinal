package com.detour.detourfinal

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Login : AppCompatActivity() {
    private val backgroundImages = arrayOf(
        R.drawable.bg2,
        R.drawable.bg3
        // Add more drawable resource IDs here
    )
    private var currentIndex = 0
    private lateinit var backgroundImageView: ImageView
    private val handler = Handler(Looper.getMainLooper())

    private val imageChangeRunnable = object : Runnable {
        override fun run() {
            // Change the background image
            val backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView)

            backgroundImageView.setImageResource(backgroundImages[currentIndex])
            currentIndex = (currentIndex + 1) % backgroundImages.size
            // Schedule the next image change after 2 seconds
            handler.postDelayed(this, 2000)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        handler.post(imageChangeRunnable)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton: TextView = findViewById<Button>(R.id.registerButton) // Initialize registerButton

        loginButton.setOnClickListener {
            Log.d("ButtonClicked", "Login Button Clicked") // Add this line
            // Display a toast message
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            Log.d("ButtonClicked", "Register Button Clicked") // Add this line
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(imageChangeRunnable)
    }
}
