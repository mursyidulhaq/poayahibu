package com.mursyidul.poayah.network.pemesanan.insertDataPemesanan

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//object NetworkModuleInsertPemesanan {
//    fun getREtrofit():Retrofit{
//        return Retrofit.Builder().baseUrl("http://192.168.43.151/PoAyah/pemesanan/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                .build()
//    }
//fun service():ApiServiceInsertPemesanan = getREtrofit().create(ApiServiceInsertPemesanan::class.java)
//}

object NetworkModuleInsertPemesanan {

    private val BASE_URL = "http://192.168.43.151/PoAyah/pemesanan/"

    val getApiClient: ApiServiceInsertPemesanan by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(ApiServiceInsertPemesanan::class.java)

    }
}