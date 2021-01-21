package com.mursyidul.poayah.view.keberangkatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mursyidul.poayah.R
import com.mursyidul.poayah.adapter.ambilData.AmbilDataAdapter
import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.DataItem
import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.ResponseServerLihatBayar
import com.mursyidul.poayah.viewModel.pemesanan.ViewModelAmbilData
import kotlinx.android.synthetic.main.activity_ambil_data_pemesanan.*

class AmbilDataPemesananActivity : AppCompatActivity() {
    lateinit var viewmodel :ViewModelAmbilData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambil_data_pemesanan)
        viewmodel = ViewModelProviders.of(this).get(ViewModelAmbilData::class.java)
        viewmodel.ambilData()

        observe()
    }

    private fun observe() {
        viewmodel.responseData.observe(this, Observer { showData(it) })
    }

    private fun showData(it: ResponseServerLihatBayar?) {
        val adapter = AmbilDataAdapter(it?.data as ArrayList<DataItem>,object :AmbilDataAdapter.itemClick{
            override fun detail(itemAmbil: DataItem?) {
                TODO("Not yet implemented")
            }

        })
        rvbayar.adapter = adapter
    }
}