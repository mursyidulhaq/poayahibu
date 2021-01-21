package com.mursyidul.poayah.view.pemesanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mursyidul.poayah.R
import kotlinx.android.synthetic.main.activity_detail_pemesanan.*
import kotlin.time.times

class DetailPemesananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pemesanan)

        val asal = intent.getStringExtra("asal")
        val tujuan  = intent.getStringExtra("tujuan")
        val tanggalkeberangkatan = intent.getStringExtra("tanggalberangkat")
        val jumlahkursi = intent.getStringExtra("jumlahkursi")?.toInt()
        val jamberangkat = intent.getStringExtra("jamberangkat")
        val jamsampai = intent.getStringExtra("jamsampai")
        val poasal = intent.getStringExtra("poasal")
        val potujuan = intent.getStringExtra("potujuan")
        val harga =intent.getStringExtra("harga")

        txtasal.setText(asal.toString())
        txttujuan.setText(tujuan.toString())
        txttanggal_keberangkatan.setText(tanggalkeberangkatan.toString())
        txtjumlahkursi.setText(jumlahkursi.toString())
        txtdjamberangkat.setText(jamberangkat.toString())
        txtdjamsampai.setText(jamsampai.toString())
        txtpoasal.setText(poasal.toString())
        txtpotujuan.setText(potujuan.toString())
        txtasal2.setText(asal.toString())
        txttujuan2.setText(tujuan.toString())

        val a = harga?.toInt()
        val b =jumlahkursi
        val total = a?.times(b ?:0)
        txttotal.setText(total.toString())

        btnpesanbus.setOnClickListener {
          val intent = Intent(applicationContext,IsiDataPemesananActivity::class.java)
            intent.putExtra("asal",asal.toString())
            intent.putExtra("tujuan",tujuan.toString())
            intent.putExtra("tanggal",tanggalkeberangkatan.toString())
            intent.putExtra("harga",harga.toString())
            intent.putExtra("jumlahtiket",jumlahkursi.toString())
            startActivity(intent)
        }


    }
}