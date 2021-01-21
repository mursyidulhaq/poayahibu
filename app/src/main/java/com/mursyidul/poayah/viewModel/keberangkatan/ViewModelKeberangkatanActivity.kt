package com.mursyidul.poayah.viewModel.keberangkatan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mursyidul.poayah.model.keberangkatan.ResponseServer
import com.mursyidul.poayah.model.keberangkatan.responseAction.ResponseAction
import com.mursyidul.poayah.repasitory.keberangkatan.KeberangkatanRepasitory
import com.mursyidul.poayah.view.keberangkatan.KeberangkatanActivity

class ViewModelKeberangkatanActivity : ViewModel() {
    val repasitory = KeberangkatanRepasitory()
    var responseData = MutableLiveData<ResponseServer>()
    var response = MutableLiveData<ResponseAction>()
    var isError = MutableLiveData<Throwable>()

    fun getList() {
        repasitory.getKeberangkatan({
            responseData.value = it
        }, {
            isError.value = it
        })
    }

    fun deleteList(id_keberangkatan: String) {
        repasitory.deleteData(id_keberangkatan ?: "", {
            response.value = it
        }, {
            isError.value = it
        })

    }
}