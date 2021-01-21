package com.mursyidul.poayah.network.pemesanan

import com.mursyidul.poayah.model.pemesanan.ResponseServerPemesanan
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceListPemesanan {
    @GET("getDataby.php")
    fun getDataPemesananBy(@Query("asal")asal :String,
                            @Query("tujuan")tujuan :String ):Flowable<ResponseServerPemesanan>
}