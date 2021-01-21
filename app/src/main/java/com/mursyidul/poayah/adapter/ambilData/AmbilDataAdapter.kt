package com.mursyidul.poayah.adapter.ambilData

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mursyidul.poayah.R
import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.DataItem
import kotlinx.android.synthetic.main.item_ambildata.view.*

class AmbilDataAdapter( private val arrayList: ArrayList<DataItem>, private val onItemClick:itemClick ) :RecyclerView.Adapter<AmbilDataAdapter.AmbilHolder>() {
 

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmbilHolder {
        val item  =LayoutInflater.from(parent.context).inflate(R.layout.item_ambildata,parent,false)
        return AmbilHolder(item)
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: AmbilHolder, position: Int) {
        val item  = arrayList.get(position)
        holder.nama.setText(item?.namaPemesan)
        holder.nohp.setText(item?.nohpPemesan)
        holder.email.setText(item?.emailPemesan)
        holder.gender.setText(item?.jenisKelamin)
        Glide.with(holder.itemView.context).load(ApiConfig.IMAGE_URL+arrayList.get(position).buktiBayar).into(holder.itemView.imgnbayar)
        holder.itemView.setOnClickListener {
            onItemClick.detail(item)
        }
    }

    class AmbilHolder(view :View):RecyclerView.ViewHolder(view) {
       val nama = view.txtnm
        val nohp = view.txnhp
        val email = view.txtnemail
        val gender = view.txtngender
    }
    interface itemClick{
        fun detail(itemAmbil: DataItem?)
    }
}