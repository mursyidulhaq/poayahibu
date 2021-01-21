package com.mursyidul.poayah.view.keberangkatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mursyidul.poayah.R
import com.mursyidul.poayah.model.keberangkatan.DataItem
import com.mursyidul.poayah.model.keberangkatan.responseAction.ResponseAction
import com.mursyidul.poayah.viewModel.keberangkatan.ViewModelInputKeberangkatanActivity
import kotlinx.android.synthetic.main.activity_input_keberangkatan.*

class InputKeberangkatanActivity : AppCompatActivity() {
    lateinit var viewmodel : ViewModelInputKeberangkatanActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_keberangkatan)
        viewmodel = ViewModelProviders.of(this).get(ViewModelInputKeberangkatanActivity::class.java)
        val data =  intent.getParcelableExtra<DataItem>("data")
        if (data != null){
            etasal.setText(data.asal)
            ettujuan.setText(data.tujuan)
            etpoasal.setText(data.poasal)
            etpotujuan.setText(data.potujuan)
            etharga.setText(data.harga)
            etberangkat.setText(data.jamBerangkat)
            etsampai.setText(data.jamSampai)
            btnsimpankeberangkatan.text = "UPDATE"
        }
        when(btnsimpankeberangkatan.text){
            "UPDATE"->{
                btnsimpankeberangkatan.setOnClickListener {
                    viewmodel.updateList(
                        data?.idKeberangkatan.toString(),
                        etasal.text.toString(),
                        ettujuan.text.toString(),
                        etpoasal.text.toString(),
                        etpotujuan.text.toString(),
                        etberangkat.text.toString(),
                        etsampai.text.toString(),
                        etharga.text.toString())
                }
            }
            else ->{btnsimpankeberangkatan.setOnClickListener {
                viewmodel.insertList(
                    etasal.text.toString(),
                    ettujuan.text.toString(),
                    etpoasal.text.toString(),
                    etpotujuan.text.toString(),
                    etberangkat.text.toString(),
                    etsampai.text.toString(),
                    etharga.text.toString())
            }
            }

        }
        attachObserve()
        btnbatalkeberangkatan.setOnClickListener {
            finish()
        }
    }

    private fun attachObserve() {
        viewmodel.response.observe(this, Observer { inpuData(it) })
        viewmodel.response.observe(this, Observer { updateData(it) })
        viewmodel.isError.observe(this, Observer { errorData(it) })
        viewmodel.isError.observe(this, Observer { errorUpdate(it) })
    }

    private fun errorUpdate(it: Throwable?) {

        Toast.makeText(applicationContext,it?.message, Toast.LENGTH_LONG).show()
    }

    private fun errorData(it: Throwable?) {
        Toast.makeText(applicationContext,it?.message, Toast.LENGTH_LONG).show()
    }

    private fun updateData(it: ResponseAction?) {
        Toast.makeText(applicationContext,"data berhasil di update", Toast.LENGTH_LONG).show()
        Log.d("success","data berhasil di update")
        finish()
    }

    private fun inpuData(it: ResponseAction?) {
        Toast.makeText(applicationContext,"data berhasil di input", Toast.LENGTH_LONG).show()
        Log.d("success","data berhasil di input")
        finish()
    }



}


