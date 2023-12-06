package com.detour.detourfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.detour.detourfinal.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var bindHome: ActivityHomeBinding
    private lateinit var DB_DETOUR : DatabaseDetour

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindHome = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bindHome.root)

        DB_DETOUR = DatabaseDetour.getDatabase(this)
    }

    override fun onStart() {
        super.onStart()

        // go to products table
        bindHome.navAll.setOnClickListener{
            SharedFuncs.goActivity(applicationContext, Products::class.java)
        }
    }
}