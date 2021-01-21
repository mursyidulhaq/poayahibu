package com.mursyidul.poayah.network.pemesanan.insertDataPemesanan

import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.Default
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


//interface ApiServiceInsertPemesanan {
//
//    @Multipart
//    @POST("insertDataPemesanan.php")
//    fun insertData(
//            @Part("nama_pemesan") nama_pemesan: RequestBody,
//            @Part("nohp_pemesan") nohp_pemesan: RequestBody,
//            @Part("email_pemesan") email_pemesan: RequestBody,
//            @Part("jenis_kelamin") jenis_kelamin: RequestBody,
//            @Part bukti_bayar: MultipartBody.Part): Flowable<ResponseServer>
//
//}
    interface ApiServiceInsertPemesanan {

        @Multipart
        @POST("insertDataPemesanan.php")
        fun insertData(
                @Part("nama_pemesan") nama_pemesan :RequestBody,
                @Part("nohp_pemesan") nohp_pemesan:RequestBody,
                @Part("email_pemesan") email_pemesan:RequestBody,
                @Part("jenis_kelamin") jenis_kelamin:RequestBody,
                @Part("bukti_bayar") bukti_bayar :MultipartBody.Part
                ): retrofit2.Call<Default>



    }

//    @FormUrlEncoded
//    @GET("getDataPemesanan.php")
//    fun getData() : Flowable<ResponseAmbilDataPemesanan>



