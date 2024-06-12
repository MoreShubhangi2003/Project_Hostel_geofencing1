package com.example.hostel_geofencing

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.KeyEvent
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.IOException
import java.util.Locale

class getlocation : AppCompatActivity() {

    var fusedLocationProviderClient: FusedLocationProviderClient? = null

    var lat: String? = null
    var log: String? = null
    var address: String? =null
    var counter=1
    var area:String?=null
    var number:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getlocation)
        val prefs = getSharedPreferences("My", AppCompatActivity.MODE_PRIVATE)
        // val mail = prefs.getString("mail", "No name defined")
         number = prefs.getString("number", "")


        Toast.makeText(applicationContext,number.toString(),Toast.LENGTH_LONG).show()

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        val i = Intent(applicationContext,studentdash::class.java)

        when(keyCode)
        {
            KeyEvent.KEYCODE_VOLUME_UP ->  mylocation()
            KeyEvent.KEYCODE_VOLUME_DOWN ->  startActivity(i)


        }
        return true


    }

    private fun mylocation() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
            return
        }

        fusedLocationProviderClient!!.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                val geocoder = Geocoder(this@getlocation, Locale.getDefault())
                try {
                    val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)


                    lat = addresses?.get(0)!!.latitude.toString()
                    log = addresses[0]!!.longitude.toString()
                    address = addresses.get(0).getAddressLine(0)
                    area = addresses.get(0).locality
                     //Toast.makeText(applicationContext,area.toString(),Toast.LENGTH_LONG).show()
                    println(".........................................."+area)
                    val sb = StringBuffer()
                    sb.append("Current location latitude").append(lat)
                    sb.append(System.getProperty("line.separator"))
                    sb.append("current location longitutde").append(log)
                    sb.append(System.getProperty("line.separator"))
                    sb.append("Current Address").append(address)
                    val msg = sb.toString()



//                    Toast.makeText(applicationContext,lat.toString(),Toast.LENGTH_LONG).show()
//                    Toast.makeText(applicationContext,log.toString(),Toast.LENGTH_LONG).show()
//                    Toast.makeText(applicationContext,addresses.get(0).getAddressLine(0),Toast.LENGTH_LONG).show()

//                    val s = send(applicationContext, "madhurioza2@gmail.com", "Call Log ", msg)
//                       s.execute()


//                    val se = send(applicationContext,mail.toString(),"Current Location",msg)
//                    se.execute()

                    if(area.equals("Mawal"))
                    {
                        val smsManager = SmsManager.getDefault() as SmsManager
                        smsManager.sendTextMessage(number,null,"Student Is Out Of Boundary",null,null)
                    }
                    if(area.equals("Talegaon"))
                    {
                        val smsManager = SmsManager.getDefault() as SmsManager
                        smsManager.sendTextMessage(number,null,"Student Is Out Of Boundary",null,null)
                    }
                    if(area.equals("Parandwadi"))
                    {
                        val smsManager = SmsManager.getDefault() as SmsManager
                        smsManager.sendTextMessage(number,null,"Student Is Out Of Boundary",null,null)
                    }
                    if(area.equals("Pimpri-Chinchwad"))
                    {
                        val smsManager = SmsManager.getDefault() as SmsManager
                        smsManager.sendTextMessage(number,null,"Student Is Out Of Boundary",null,null)
                    }


                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

    }


}
