package com.eremenko.dublinmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose_city.*

class ChooseCity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)

        val actionBar = supportActionBar
        actionBar!!.title = "Choose city"

        // made btn listener

        btnDublin.setOnClickListener {
            Intent(this, MapsActivity::class.java).also {
                startActivity(it)
            }

        }


        btnParis.setOnClickListener {
            Intent(this, MapsActivity::class.java).also {
                startActivity(it)
            }

        }



    }
}