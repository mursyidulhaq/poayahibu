package com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan

import com.google.gson.annotations.SerializedName

data class Image(

        @field:SerializedName("id_pemesanan")
        val idPemesanan: String? = null,

        @field:SerializedName("imagename")
        val imagename: String? = null
)