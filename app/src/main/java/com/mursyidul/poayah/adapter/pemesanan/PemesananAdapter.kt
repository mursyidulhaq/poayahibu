package com.mursyidul.poayah.adapter.pemesanan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mursyidul.poayah.R
import com.mursyidul.poayah.model.pemesanan.DataItem
import kotlinx.android.synthetic.main.list_pemesanan.view.*

class PemesananAdapter(val dataPemesanan : List<DataItem>?,val onItemClick : itemClick) : RecyclerView.Adapter<PemesananAdapter.PemesananHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PemesananHolder {
        val itemPemesanan = LayoutInflater.from(parent.context).inflate(R.layout.list_pemesanan,parent,false)
        return PemesananHolder(itemPemesanan)
    }

    override fun getItemCount(): Int {
        return  dataPemesanan?.size ?:0

    }

    override fun onBindViewHolder(holder: PemesananHolder, position: Int) {
        val item = dataPemesanan?.get(position)
        holder.jamberangkat.setText(item?.jamBerangkat)
        holder.jamsampai.setText(item?.jamSampai)
        holder.harga.setText(item?.harga)
        //holder.jumlahtiket.setText(item?.jumlahTiket)

        holder.itemView.setOnClickListener {
                onItemClick.detail(item)
        }


    }
    class PemesananHolder(viewPemesanan : View) :RecyclerView.ViewHolder(viewPemesanan) {
        val jamberangkat = viewPemesanan.txtjamberangkat
        val jamsampai = viewPemesanan.txtjamsampai
        val harga = viewPemesanan.txtharga
       //val jumlahtiket = viewPemesanan.
    }

    interface itemClick{
            fun detail(item: DataItem?)
    }

}