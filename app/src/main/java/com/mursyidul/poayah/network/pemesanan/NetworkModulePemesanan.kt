package com.mursyidul.poayah.network.pemesanan

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModulePemesanan {

    fun retrofit():Retrofit{
        return Retrofit.Builder().baseUrl("http://192.168.43.151/PoAyah/pemesanan/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    fun service():ApiServiceListPemesanan = retrofit().create(ApiServiceListPemesanan::class.java)
}