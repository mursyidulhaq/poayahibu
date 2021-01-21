package com.mursyidul.poayah.adapter.keberangkatan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mursyidul.poayah.R
import com.mursyidul.poayah.model.keberangkatan.DataItem
import kotlinx.android.synthetic.main.list_keberangkatan.view.*

class KeberangkatanAdapter(val Data : List<DataItem>?, val itemClick : onClickListener) : RecyclerView.Adapter<KeberangkatanAdapter.KeberangkatanHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeberangkatanHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_keberangkatan,parent,false)
        return KeberangkatanHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return Data?.size ?:0
    }

    override fun onBindViewHolder(holder: KeberangkatanHolder, position: Int) {
        val item = Data?.get(position)
        holder.asalkeberangkatan.text = item?.asal
        holder.tujuankeberangkatan.text = item?.tujuan
        holder.poasalkeberangkatan.text = item?.poasal
        holder.potujuankeberangkatan.text = item?.potujuan
        holder.jamberangkat.text = item?.jamBerangkat
        holder.jamsamapi.text = item?.jamSampai
        holder.hargakeberangkatan.text = item?.harga



        holder.view.setOnClickListener {
            itemClick.detail(item)

        }
        holder.delete.setOnClickListener {
            itemClick.hapus(item)
        }
    }

    class KeberangkatanHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val asalkeberangkatan = view.txtasal
        val tujuankeberangkatan = view.txttujuan
        val poasalkeberangkatan = view.txtpoasal
        val potujuankeberangkatan = view.txtpotujuan
        val jamberangkat =view.txtjamkeberangkatan
        val jamsamapi = view.txtjamksampai
        val hargakeberangkatan = view.txtharga
        val delete = view.btndelete


    }

    interface onClickListener{
        fun detail(item: DataItem?)
        fun hapus(item: DataItem?)
    }

}