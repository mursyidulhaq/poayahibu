package com.mursyidul.poayah.network.pemesanan.getDataPemesanan

import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.ResponseServerLihatBayar
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiServiceGetDataPemesanan {

    @GET("lihatBayar.php")
    fun getDataPemesenan():Flowable<ResponseServerLihatBayar>
}