package com.example.hostel_geofencing

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class hosteldash : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hosteldash)
        val adddriver = findViewById<ImageView>(R.id.adddriver)

        adddriver.setOnClickListener {
            val intent = Intent(applicationContext, Showleaves::class.java)
            startActivity(intent)

        }

        val showcom = findViewById<ImageView>(R.id.tips)

        showcom.setOnClickListener {
            val intent = Intent(applicationContext, Home::class.java)
            startActivity(intent)

        }


    }
}