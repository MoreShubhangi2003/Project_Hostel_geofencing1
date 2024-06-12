package com.example.hostel_geofencing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hostel_geofencing.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val img1 = binding.client
        val img2 = binding.owner



        img1.setOnClickListener {
           // Toast.makeText(applicationContext,"Hostel",Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        img2.setOnClickListener {
            Toast.makeText(applicationContext,"Student",Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext,Studentlogin::class.java)
            startActivity(intent)
        }
    }
}