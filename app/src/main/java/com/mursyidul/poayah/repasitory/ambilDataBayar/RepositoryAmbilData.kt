package com.mursyidul.poayah.repasitory.ambilDataBayar

import ApiConfig
import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.ResponseServerLihatBayar
import com.mursyidul.poayah.network.pemesanan.getDataPemesanan.NetworkModuleGetData
import com.mursyidul.poayah.network.pemesanan.insertDataPemesanan.NetworkModuleInsertPemesanan
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryAmbilData {
    fun getData(responseHandler : (ResponseServerLihatBayar)->Unit,errorHandler :(Throwable)->Unit){
        NetworkModuleGetData.service().getDataPemesenan().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })

    }
}