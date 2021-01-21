package com.mursyidul.poayah.network.keberangkatan

import com.mursyidul.poayah.model.keberangkatan.ResponseServer
import com.mursyidul.poayah.model.keberangkatan.responseAction.ResponseAction
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("getDataKeberangkatan.php")
    fun getData():Flowable<ResponseServer>
    @FormUrlEncoded
    @POST("insertKeberangkatan.php")
    fun insertKebrangkatan (@Field("asal")asal :String,
                            @Field("tujuan")tujuan :String,
                            @Field("poasal")poasal :String,
                            @Field("potujuan")potujuan :String,
                            @Field("jam_berangkat")jam_berangkat :String,
                            @Field("jam_sampai")jam_sampai :String,
                            @Field("harga")harga :String):Flowable<ResponseAction>
    @FormUrlEncoded
    @POST("updateKeberangkatan.php")
    fun updateKebrangkatan (@Field("id_keberangkatan")id_keberangkatan :String,
                            @Field("asal")asal :String,
                            @Field("tujuan")tujuan :String,
                            @Field("poasal")poasal :String,
                            @Field("potujuan")potujuan :String,
                            @Field("jam_berangkat")jam_berangkat :String,
                            @Field("jam_sampai")jam_sampai :String,
                            @Field("harga")harga :String):Flowable<ResponseAction>
    @FormUrlEncoded
    @POST("deleteKeberangkatan.php")
    fun deleteKeberangkatan(@Field("id_keberangkatan")id_keberangkatan :String) : Flowable<ResponseAction>
}