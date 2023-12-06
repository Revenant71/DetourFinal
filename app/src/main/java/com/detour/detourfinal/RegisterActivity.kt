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
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val afterRegisterButton = findViewById<Button>(R.id.afterRegisterButton)

        afterRegisterButton.setOnClickListener {
            Log.d("ButtonClicked", "Login Button Clicked") // Add this line
            // Display a toast message
            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }


    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }


}