package com.mursyidul.poayah.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mursyidul.poayah.R
import com.mursyidul.poayah.view.keberangkatan.LoginActivity
import com.mursyidul.poayah.view.pemesanan.PemesananActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCari.setOnClickListener {
            val intent = Intent(applicationContext,PemesananActivity::class.java)
            startActivity(intent)
        }
       idback.setOnClickListener {
           val intent = Intent(applicationContext,
               LoginActivity::class.java)
           startActivity(intent)
       }
    }
}