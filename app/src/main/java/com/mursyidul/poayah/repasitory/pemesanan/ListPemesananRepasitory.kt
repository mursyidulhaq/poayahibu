package com.mursyidul.poayah.repasitory.pemesanan

import com.mursyidul.poayah.model.pemesanan.ResponseServerPemesanan
import com.mursyidul.poayah.network.pemesanan.NetworkModulePemesanan
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListPemesananRepasitory {
fun getData(asal :String, tujuan :String, responseHandler :(ResponseServerPemesanan)->Unit, errorHanler :(Throwable)->Unit) {
    NetworkModulePemesanan.service().getDataPemesananBy(asal, tujuan)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            responseHandler(it)
        }, {
            errorHanler(it)
        })
}
//    fun inserDataPemesanan(
//        nama_pemesan:RequestBody, nohp_pemesanan:RequestBody, email_pemesanan:RequestBody, jenis_kelamin:RequestBody,
//        bukti_bayar: MultipartBody.Part, responseHandler:(ResponseServer)->Unit, errorHandler:(Throwable)->Unit){
//        NetworkModuleInsertPemesanan.service().insertData(nama_pemesan,nohp_pemesanan,email_pemesanan,jenis_kelamin,bukti_bayar)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                responseHandler(it)
//            },{
//                errorHandler(it)
//            })
//
//    }

}





