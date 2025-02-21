package com.example.hostel_geofencing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.hostel_geofencing.databinding.ActivityMainBinding
import com.example.hostel_geofencing.databinding.ActivityStudentloginBinding
import com.google.firebase.auth.FirebaseAuth

class Studentlogin : AppCompatActivity() {

    private lateinit var binding: ActivityStudentloginBinding
    lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentloginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val edemail = binding.username
        val edpassword = binding.password

        val btnlogin = binding.loginButton
        val btnregister = binding.signupText
        btnregister.setOnClickListener {
            val intent = Intent(applicationContext,Studentregister::class.java)
            startActivity(intent)

        }





        auth = FirebaseAuth.getInstance()

        //login
        btnlogin.setOnClickListener {

            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(edemail.text.toString()).matches()) {
                edemail.setError("Enter Email Id")
                return@setOnClickListener
            }
            else if (edpassword.text.isEmpty()){
                edpassword.setError("Enter Password")
                return@setOnClickListener
            }



            auth.signInWithEmailAndPassword(edemail.text.toString(),edpassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        Toast.makeText(applicationContext,"successfully Login", Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext,studentdash::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Failed to login", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}