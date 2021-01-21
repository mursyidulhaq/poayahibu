package com.mursyidul.poayah.model.keberangkatan

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

    @field:SerializedName("asal")
    val asal: String? = null,

    @field:SerializedName("poasal")
    val poasal: String? = null,

    @field:SerializedName("potujuan")
    val potujuan: String? = null,

    @field:SerializedName("harga")
    val harga: String? = null,

    @field:SerializedName("id_keberangkatan")
    val idKeberangkatan: String? = null,

    @field:SerializedName("jam_sampai")
    val jamSampai: String? = null,

    @field:SerializedName("tujuan")
    val tujuan: String? = null,

    @field:SerializedName("jam_berangkat")
    val jamBerangkat: String? = null
) :Parcelable
