package com.mursyidul.poayah.view.pemesanan

import ApiConfig
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mursyidul.poayah.R
import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.Default
import com.vincent.filepicker.Constant
import com.vincent.filepicker.Constant.RESULT_PICK_IMAGE
import com.vincent.filepicker.activity.ImagePickActivity
import com.vincent.filepicker.filter.entity.ImageFile
import kotlinx.android.synthetic.main.activity_data_pemesanan.*
import kotlinx.android.synthetic.main.activity_pembayaran.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Response
import java.io.File


class PembayaranActivity : AppCompatActivity() {

  // global variable untuk imagename.
  lateinit var imagename:MultipartBody.Part
  lateinit var namap :RequestBody
  lateinit var jkp :RequestBody
  lateinit var nohpp :RequestBody
  lateinit var emailp :RequestBody

    override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_pembayaran)
     val nama = intent.getStringExtra("nm")
     val jk = intent.getStringExtra("jk")
     val nohp = intent.getStringExtra("nohp")
     val email = intent.getStringExtra("email")

     txtnamabayar.setText(nama)
     jkbayar.setText(jk)
     nohpbayar.setText(nohp)
     emailbayar.setText(email)

     // set title pada action bar.
     supportActionBar?.title = "Upload"

     // manampilkan tombol back pada action bar.
     supportActionBar?.setDisplayHomeAsUpEnabled(true)

     // memberikan onClick listener pada btnPickUpload
     btn_choose_image.setOnClickListener {

      // check permission untuk android M dan ke atas.
      // saat permission disetujui oleh user maka jalan script untuk intent ke pick image.
      if(EasyPermissions.hasPermissions(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
       val i = Intent(this,ImagePickActivity::class.java)
       i.putExtra(Constant.MAX_NUMBER,1)
       startActivityForResult(i, Constant.REQUEST_CODE_PICK_IMAGE)
      }else{
       // tampilkan permission request saat belum mendapat permission dari user
       EasyPermissions.requestPermissions(this,"This application need your permission to access photo gallery.",991,android.Manifest.permission.READ_EXTERNAL_STORAGE)
      }

     }

     // membrikan onclick listener pada btnUpload
     btnsimpanbayar.setOnClickListener {

      // memanggil method upload
      upload()

     }


    }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
   when(item?.itemId){

    android.R.id.home->{
     this.finish()
    }

   }
   return super.onOptionsItemSelected(item)
  }


  // override method onActivityResult untuk handling data dari pickImageActivity.
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
   super.onActivityResult(requestCode, resultCode, data)

   if(requestCode == Constant.REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null){

    // menghiden button btnPickUpload.
    btn_choose_image.visibility = View.GONE

    // memunculkan btnUpload dan imgUpload.
    btnsimpanbayar.visibility = View.VISIBLE
    image_view.visibility = View.VISIBLE

    val nama = intent.getStringExtra("nm")
    val jk = intent.getStringExtra("jk")
    val nohp = intent.getStringExtra("nohp")
    val email = intent.getStringExtra("email")

    val n = txtnamabayar.setText(nama)
    val jkb = jkbayar.setText(jk)
    val nhpp = nohpbayar.setText(nohp)
    val emp = emailbayar.setText(email)

    namap = RequestBody.create(MediaType.parse("nama"),nama.toString().trim())
    jkp = RequestBody.create(MediaType.parse("alamat"),jk.toString().trim())
    nohpp = RequestBody.create(MediaType.parse("nohp"),nohp.toString().trim())
    emailp = RequestBody.create(MediaType.parse("nohp"),email.toString().trim())
    // membuat variable yang menampung path dari picked image.
    val pickedImg = data.getParcelableArrayListExtra<ImageFile>(RESULT_PICK_IMAGE)!![0]?.path

    // membuat request body yang berisi file dari picked image.
    val requestBody = RequestBody.create(MediaType.parse("multipart"), File(pickedImg))

    // mengoper value dari requestbody sekaligus membuat form data untuk upload. dan juga mengambil nama dari picked image
    imagename = MultipartBody.Part.createFormData("imagename",File(pickedImg)?.name,requestBody)

    // mempilkan image yang akan diupload dengan glide ke imgUpload.
    Glide.with(this).load(pickedImg).into(image_view)

   }



  }

  private fun upload(){

   // meampilkan progress dialog
   val loading = ProgressDialog(this)
   loading.setMessage("Please wait...")
   loading.show()

   // init retrofit
   val call = ApiConfig().instance().upload(imagename,namap,nohpp,jkp,emailp)

   // membaut request ke api
   call.enqueue(object : retrofit2.Callback<Default>{

    // handling request saat fail
    override fun onFailure(call: Call<Default>?, t: Throwable?) {
     loading.dismiss()
     Toast.makeText(applicationContext,t?.message,Toast.LENGTH_SHORT).show()
     Log.d("ONFAILURE",t.toString())
    }

    // handling request saat response.
    override fun onResponse(call: Call<Default>?, response: Response<Default>?) {

     // dismiss progress dialog
     loading.dismiss()

     // menampilkan pesan yang diambil dari response.
     Toast.makeText(applicationContext,response?.body()?.message,Toast.LENGTH_SHORT).show()

     // saat pesan mempunyai kata 'success' maka tutup/akhiri activity ini.
     if(response?.body()?.message?.contains("Success",true)!!){
      this@PembayaranActivity.finish()
     }

    }


   })

  }

 }

















