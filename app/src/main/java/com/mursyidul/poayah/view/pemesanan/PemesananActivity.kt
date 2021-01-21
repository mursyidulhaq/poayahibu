package com.mursyidul.poayah.view.pemesanan

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mursyidul.poayah.R
import kotlinx.android.synthetic.main.activity_pemesanan.*
import java.text.SimpleDateFormat
import java.util.*


class PemesananActivity : AppCompatActivity() {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan)

        cvimage.setOnClickListener {
            showDate()
        }


            btncaritiket.setOnClickListener {
                if (spasal.selectedItem.toString().isEmpty()) {
                        Toast.makeText(applicationContext,"asal harus di pilih",Toast.LENGTH_SHORT).show()

                }else if(sptujuan.selectedItem.toString().isEmpty()){

                    Toast.makeText(applicationContext,"tujuan harus di pilih",Toast.LENGTH_SHORT).show()
                }else if(txttnggal.text.toString().isEmpty()){
                    txttnggal.setError("data tanggal harus di isi")
                }

                else
                 {
                    val intent = Intent(applicationContext, ListPemesananActivity::class.java)
                    intent.putExtra("asal", spasal.selectedItem.toString())
                     intent.putExtra("tujuan", sptujuan.selectedItem.toString())
                    intent.putExtra("tanggal", txttnggal.text.toString())
                     intent.putExtra("jumlahkursi",spjumlahtket.selectedItem.toString())

                    startActivity(intent)
                }
                }
            }

    private fun showDate() {
        val calender = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                val newDate = Calendar.getInstance()
                newDate[year, monthOfYear] = dayOfMonth

                txttnggal.setText(dateFormat.format(newDate.time))
            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH))

        datePickerDialog.show()
    }
}
