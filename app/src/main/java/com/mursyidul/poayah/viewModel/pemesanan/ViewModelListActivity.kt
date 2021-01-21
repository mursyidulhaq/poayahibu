package com.mursyidul.poayah.viewModel.pemesanan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mursyidul.poayah.model.pemesanan.ResponseServerPemesanan
import com.mursyidul.poayah.repasitory.pemesanan.ListPemesananRepasitory

class ViewModelListActivity :ViewModel() {
    val repasitor = ListPemesananRepasitory()
    val response = MutableLiveData<ResponseServerPemesanan>()
    val isError = MutableLiveData<Throwable>()
fun getListPemesanan(asal :String,tujuan :String){
    repasitor.getData(asal ?:"",tujuan ?:"",{
        response.value = it
    },{
        isError.value = it
    })
}
}