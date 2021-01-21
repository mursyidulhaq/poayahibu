 package com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan

import com.google.gson.annotations.SerializedName

data class ResponseServerLihatBayar(

	@field:SerializedName("data")
	var data: List<DataItem>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

data class DataItem(

	@field:SerializedName("id_pemesanan")
	val idPemesanan: String? = null,

	@field:SerializedName("bukti_bayar")
	val buktiBayar: String? = null,

	@field:SerializedName("nama_pemesan")
	val namaPemesan: String? = null,

	@field:SerializedName("nohp_pemesan")
	val nohpPemesan: String? = null,

	@field:SerializedName("email_pemesan")
	val emailPemesan: String? = null,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String? = null
)
