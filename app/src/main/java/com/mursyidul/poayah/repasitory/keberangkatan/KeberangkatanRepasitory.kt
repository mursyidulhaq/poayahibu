package com.mursyidul.poayah.repasitory.keberangkatan

import com.mursyidul.poayah.model.keberangkatan.ResponseServer
import com.mursyidul.poayah.model.keberangkatan.responseAction.ResponseAction
import com.mursyidul.poayah.network.keberangkatan.NetworkModul
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class KeberangkatanRepasitory {
    fun getKeberangkatan(responseHandler :(ResponseServer)->Unit, errorHandler : (Throwable)->Unit){
        NetworkModul.service().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })

    }
    fun getInputKeberangkatn(asal : String,tujuan :String,poasal :String,potujuan:String,jam_berangkat :String,jam_sampai :String,harga :String,responseHandler: (ResponseAction) -> Unit, errorHandler: (Throwable) -> Unit){
        NetworkModul.service().insertKebrangkatan(asal,tujuan,poasal,potujuan,jam_berangkat,jam_sampai,harga).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }
    fun getUpdateList(id_keberangkatan :String,asal : String,tujuan :String,poasal :String,potujuan:String,jam_berangkat :String,jam_sampai :String,harga :String,responseHandler: (ResponseAction) -> Unit,errorHandler: (Throwable) -> Unit){
        NetworkModul.service().updateKebrangkatan(id_keberangkatan,asal,tujuan,poasal,potujuan,jam_berangkat,jam_sampai,harga).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)

            })
    }
    fun deleteData(id_keberangkatan : String, responseHandler: (ResponseAction) -> Unit, errorHandler: (Throwable) -> Unit){
        NetworkModul.service().deleteKeberangkatan(id_keberangkatan).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }
}