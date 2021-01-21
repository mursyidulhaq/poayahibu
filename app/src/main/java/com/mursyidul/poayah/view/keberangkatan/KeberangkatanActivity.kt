package com.mursyidul.poayah.view.keberangkatan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mursyidul.poayah.R
import com.mursyidul.poayah.adapter.keberangkatan.KeberangkatanAdapter
import com.mursyidul.poayah.model.keberangkatan.DataItem
import com.mursyidul.poayah.model.keberangkatan.ResponseServer
import com.mursyidul.poayah.model.keberangkatan.responseAction.ResponseAction
import com.mursyidul.poayah.view.MainActivity
import com.mursyidul.poayah.viewModel.keberangkatan.ViewModelKeberangkatanActivity
import kotlinx.android.synthetic.main.activity_keberangkatan.*

class KeberangkatanActivity : AppCompatActivity() {

    lateinit var viewmodel :ViewModelKeberangkatanActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keberangkatan)
        viewmodel = ViewModelProviders.of(this).get(ViewModelKeberangkatanActivity::class.java)


        home.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        fabk.setOnClickListener {
            val intent= Intent(applicationContext,InputKeberangkatanActivity::class.java)
            startActivity(intent)
        }

        viewmodel.getList()
        attachObserve()
    }

    private fun attachObserve() {
        viewmodel.responseData.observe(this, Observer { showData(it) })
        viewmodel.isError.observe(this, Observer { showError(it) })

        ///delete
        viewmodel.response.observe(this, Observer { deleteData(it) })
        viewmodel.isError.observe(this, Observer { errorData(it) })

    }

    private fun errorData(it: Throwable?) {
        Toast.makeText(applicationContext,it?.message, Toast.LENGTH_LONG).show()
    }

    private fun deleteData(it: ResponseAction?) {
        Toast.makeText(applicationContext,it?.message, Toast.LENGTH_LONG).show()
        viewmodel.getList()
    }

    private fun showError(it: Throwable?) {
        Toast.makeText(applicationContext,it?.message, Toast.LENGTH_LONG).show()
    }

    private fun showData(it: ResponseServer?) {
        val adapter = KeberangkatanAdapter(it?.data,object : KeberangkatanAdapter.onClickListener{
            override fun detail(item: DataItem?) {
                val intent = Intent(applicationContext,InputKeberangkatanActivity::class.java)
                intent.putExtra("data",item)
                startActivity(intent)
            }

            override fun hapus(item: DataItem?) {
                AlertDialog.Builder(this@KeberangkatanActivity).apply {
                    setTitle("Hapus Data")
                    setMessage("yakin mau menghapus data ?")
                    setPositiveButton("hapus"){dialog, which ->viewmodel.deleteList(item?.idKeberangkatan.toString())
                        dialog.dismiss()}
                    setNegativeButton("Batal"){dialog,which->dialog.dismiss()

                    }
                }.show()
            }

        }  )
        rvkeberangkatan.adapter = adapter
    }
    override fun onResume() {
        super.onResume()
        viewmodel.getList()

    }

}


