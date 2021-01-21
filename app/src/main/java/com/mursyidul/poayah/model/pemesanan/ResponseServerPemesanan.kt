package com.mursyidul.poayah.model.pemesanan

import com.google.gson.annotations.SerializedName

data class ResponseServerPemesanan(

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

