package com.example.hostel_geofencing

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class leavedetails : AppCompatActivity() {

    var name:String?=null
    var material:String?=null
    var manifacute:String?=null
    var origin:String?=null
    var weight:String?=null
    var rating:String?=null
    var demi:String?=null
    var price:String?=null
    var ref: DatabaseReference? = null

    var username:String?=null
    var usermobile:String?=null
    var useremail:String?=null
    var useraddress:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leavedetails)

        val txtproname = findViewById<TextView>(R.id.txtname)
        val txtmaterial = findViewById<TextView>(R.id.txtmaterial)
        val txtaddress = findViewById<TextView>(R.id.txtmanifacture)

        val txtarea = findViewById<TextView>(R.id.txtorigin)

        val mSharedPreference = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val value = mSharedPreference.getString("user-email", "DEFAULT")

        val bundle = intent.extras

        name = bundle?.getString("name")
        material = bundle?.getString("number")
        manifacute=bundle?.getString("date")
        origin = bundle?.getString("reason")


        txtproname.setText("Student :" +name)
        txtmaterial.setText("Parent Number: "+material)
        txtaddress.setText("Reason:  "+manifacute)
        txtarea.setText("Days: "+origin)

        val btn = findViewById<Button>(R.id.btnorder)
        btn.setOnClickListener {

         Toast.makeText(applicationContext,"call",Toast.LENGTH_LONG).show()

            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$material")
            startActivity(callIntent)


        }

        val btnuser = findViewById<Button>(R.id.btnuser)
        btnuser.setOnClickListener {
            val data = FirebaseDatabase.getInstance().getReference().child("permission")
            val service = Permission(name,material,origin,manifacute,"yes")


            data.push().setValue(service)

            Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()

        }
    }
}