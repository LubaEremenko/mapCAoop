package com.eremenko.dublinmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ChooseCity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)

        val actionBar = supportActionBar
        actionBar!!.title = "Choose city"

        // made btn listener

        val btnDublin
        btnDublin.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val btnParis
        btnParis.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }



    }
}