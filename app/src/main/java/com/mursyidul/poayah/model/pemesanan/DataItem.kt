package com.mursyidul.poayah.model.pemesanan

import com.google.gson.annotations.SerializedName

data class DataItem(

    @field:SerializedName("asal")
    val asal: String? = null,

    @field:SerializedName("tanggal_keberangkatan")
    val tanggalKeberangkatan: String? = null,

    @field:SerializedName("poasal")
    val poasal: String? = null,

    @field:SerializedName("potujuan")
    val potujuan: String? = null,

    @field:SerializedName("harga")
    val harga: String? = null,

    @field:SerializedName("jumlah_tiket")
    val jumlahTiket: String? = null,

    @field:SerializedName("id_keberangkatan")
    val idKeberangkatan: String? = null,

    @field:SerializedName("jam_sampai")
    val jamSampai: String? = null,

    @field:SerializedName("tujuan")
    val tujuan: String? = null,

    @field:SerializedName("jam_berangkat")
    val jamBerangkat: String? = null
)
