package com.mursyidul.poayah.view.pemesanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mursyidul.poayah.R
import com.mursyidul.poayah.adapter.pemesanan.PemesananAdapter
import com.mursyidul.poayah.model.pemesanan.DataItem
import com.mursyidul.poayah.model.pemesanan.ResponseServerPemesanan
import com.mursyidul.poayah.viewModel.pemesanan.ViewModelListActivity
import kotlinx.android.synthetic.main.activity_list_pemesanan.*

class ListPemesananActivity : AppCompatActivity() {
    lateinit var viewmodel : ViewModelListActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pemesanan)
        viewmodel = ViewModelProviders.of(this).get(ViewModelListActivity::class.java)
        val asal = intent.getStringExtra("asal")
        val tujuan = intent.getStringExtra("tujuan")


        viewmodel.getListPemesanan(asal.toString(),tujuan.toString())
        oserveData()


    }

    private fun oserveData() {
        viewmodel.response.observe(this, Observer { showData(it) })
        viewmodel.isError.observe(this, Observer { errorData(it) })
    }

    private fun errorData(it: Throwable?) {
        Toast.makeText(applicationContext,it?.message,Toast.LENGTH_LONG).show()
        Log.d(it?.message,"data gagal di ambil")
    }

    private fun showData(it: ResponseServerPemesanan?) {
        val adapter = PemesananAdapter(it?.data, object : PemesananAdapter.itemClick{
            override fun detail(item: DataItem?) {
                val tanggal = intent.getStringExtra("tanggal")
                val jumlah_tiket = intent.getStringExtra("jumlahkursi")
                val intent = Intent(applicationContext,DetailPemesananActivity::class.java)
                intent.putExtra("asal",item?.asal.toString())
                intent.putExtra("tujuan",item?.tujuan.toString())
                intent.putExtra("tanggalberangkat",tanggal.toString())
                intent.putExtra("jumlahkursi",jumlah_tiket.toString())
                intent.putExtra("jamberangkat",item?.jamBerangkat)
                intent.putExtra("jamsampai",item?.jamSampai)
                intent.putExtra("poasal",item?.poasal.toString())
                intent.putExtra("potujuan",item?.potujuan.toString())
                intent.putExtra("harga",item?.harga)
                startActivity(intent)

            }

        } )
        rvlistpemesanan.adapter = adapter
    }


}


