package com.mursyidul.poayah.viewModel.keberangkatan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mursyidul.poayah.model.keberangkatan.responseAction.ResponseAction
import com.mursyidul.poayah.repasitory.keberangkatan.KeberangkatanRepasitory

class ViewModelInputKeberangkatanActivity :ViewModel(){
    val repasitory = KeberangkatanRepasitory()
    val response = MutableLiveData<ResponseAction>()
    val isError = MutableLiveData<Throwable>()
    fun insertList(asal : String,tujuan :String,poasal :String,potujuan:String,jam_berangkat :String,jam_sampai :String,harga :String){
        repasitory.getInputKeberangkatn(asal ?:"",tujuan ?:"",poasal ?:"",potujuan ?:"",jam_berangkat ?:"",jam_sampai ?:"",harga ?:"",{
            response.value = it
        },{
            isError.value = it
        })

    }
    fun updateList(id_keberangkatan : String,asal : String,tujuan :String,poasal :String,potujuan:String,jam_berangkat :String,jam_sampai :String,harga :String){
        repasitory.getUpdateList(id_keberangkatan ?: "",asal ?:"",tujuan ?:"",poasal ?:"",potujuan ?:"",jam_berangkat ?:"",jam_sampai ?:"",harga ?:"",{
            response.value = it
        },{
            isError.value = it
        })
    }
}