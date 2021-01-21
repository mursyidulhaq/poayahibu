package com.mursyidul.poayah.view.pemesanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mursyidul.poayah.R
import kotlinx.android.synthetic.main.activity_data_pemesanan.*

class DataPemesananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pemesanan)




            btnsimpan.setOnClickListener {
                if (etnama.text.toString().isEmpty()) {
                    etnama.setText("nama harus disisi")
                }else if(etemail.text.toString().isEmpty()){
                    etemail.setText("email tidak boleh kosong")
                }else if (etnohp.text.toString().isEmpty()){
                    etnohp.setText("nohp tidak boleh kosong")
                }else {

                val intent = Intent(applicationContext,IsiDataPemesananActivity::class.java)
                    intent.putExtra("nama",etnama.text.toString())
                    intent.putExtra("jk",etjk.selectedItem.toString())
                    intent.putExtra("nohp",etnohp.text.toString())
                    intent.putExtra("email",etemail.text.toString())
                startActivity(intent)
            }
        }
        btnbatal.setOnClickListener {
            finish()
        }

    }




}