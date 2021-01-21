package com.mursyidul.poayah.viewModel.pemesanan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.ResponseServerLihatBayar
import com.mursyidul.poayah.repasitory.ambilDataBayar.RepositoryAmbilData

class ViewModelAmbilData : ViewModel() {

    val repasitori = RepositoryAmbilData()
    val responseData = MutableLiveData<ResponseServerLihatBayar>()
    val isError = MutableLiveData<Throwable>()
    fun ambilData(){
        repasitori.getData({
            responseData.value = it
        },{
            isError.value = it
        })
    }
    }


