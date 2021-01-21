package com.mursyidul.poayah.view.keberangkatan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mursyidul.poayah.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       btnLogin.setOnClickListener {
           if (etEmail.text.toString() =="mursyidulhaq78@gmail.com" && etPassword.text.toString() =="admin"){
               val intent = Intent(applicationContext,KeberangkatanActivity::class.java)
               startActivity(intent)
           }else{
               Toast.makeText(applicationContext,"email atau password tidak cocok",Toast.LENGTH_SHORT).show()
           }
       }
    }
}