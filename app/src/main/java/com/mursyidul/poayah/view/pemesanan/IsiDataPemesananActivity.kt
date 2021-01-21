package com.mursyidul.poayah.view.pemesanan

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.google.android.gms.common.internal.service.Common.CLIENT_KEY
//import com.midtrans.sdk.corekit.BuildConfig.BASE_URL
//import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback
//import com.midtrans.sdk.corekit.core.MidtransSDK
//import com.midtrans.sdk.corekit.core.PaymentMethod
//import com.midtrans.sdk.corekit.core.TransactionRequest
//import com.midtrans.sdk.corekit.core.themes.CustomColorTheme
//import com.midtrans.sdk.corekit.models.BankType
//import com.midtrans.sdk.corekit.models.CustomerDetails
//import com.midtrans.sdk.corekit.models.snap.CreditCard
//import com.midtrans.sdk.corekit.models.snap.CreditCard.AUTHENTICATION_TYPE_RBA
//import com.midtrans.sdk.corekit.models.snap.ItemDetails
//import com.midtrans.sdk.corekit.models.snap.TransactionResult
//import com.midtrans.sdk.uikit.BuildConfig
//import com.midtrans.sdk.uikit.SdkUIFlowBuilder
import com.mursyidul.poayah.R
import kotlinx.android.synthetic.main.activity_isi_data_pemesanan.*
//import com.midtrans.sdk.corekit.models.snap.CustomerDetails as CustomerDetails1


class IsiDataPemesananActivity : AppCompatActivity()/*, TransactionFinishedCallback*/ {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_data_pemesanan)
        //data pemesanan
        val namapemesan = intent.getStringExtra("nama")
        val jk = intent.getStringExtra("jk")
        val nohp = intent.getStringExtra("nohp")
        val email = intent.getStringExtra("email")


        //detail
       val asaldetail =  intent.getStringExtra("asal")
        val tujuandetail = intent.getStringExtra("tujuan")
        val tanggal = intent.getStringExtra("tanggal")

        val jumlahtiketetail = intent.getStringExtra("jumlahtiket")

        txtasal3.setText(asaldetail)
        txttujuan3.setText(tujuandetail)
        txttanggal3.setText(tanggal)

        feb.setOnClickListener {
            val intent = Intent(applicationContext, DataPemesananActivity::class.java)
            startActivity(intent)
        }

       // val nama = intent.getStringExtra("nama")
        etisinama.setText(namapemesan)

        if (etisinama.text.toString().isEmpty()) {
            etisinama.setError("data pemesanan harus disisi")
        } else {
            bayar.setOnClickListener {
                val intent = Intent(applicationContext,PembayaranActivity::class.java)
                intent.putExtra("nm",namapemesan.toString())
                intent.putExtra("jk",jk.toString())
                intent.putExtra("nohp",nohp.toString())
                intent.putExtra("email",email.toString())
                startActivity(intent)
                //clickPay()
            }

           // makePaymentPay()


        }
    }
    /*
    private fun makePaymentPay() {
        SdkUIFlowBuilder.init()
            .setContext(this)
            .setMerchantBaseUrl("https://poayah.herokuapp.com/index.php/")
            .setClientKey("SB-Mid-client-g8UgdBSTBFrOFjn_")
            .setTransactionFinishedCallback(this)
            .enableLog(false)
            .setColorTheme(CustomColorTheme("#777777", "#f77474", "#3f0d0d"))
            .buildSDK()
    }

    private fun clickPay() {
        val hargadetail = intent.getStringExtra("harga")
        val nama = intent.getStringExtra("nama")
        MidtransSDK.getInstance().transactionRequest = transactionRequest(
            "1", hargadetail!!.toDouble(),1,nama.toString()
        )
        MidtransSDK.getInstance().startPaymentUiFlow(this)
    }
    private  fun transactionRequest( id :String,price :Double,qty : Int,name :String): TransactionRequest {

        val request = TransactionRequest(System.currentTimeMillis().toString() +" ", 2000.0)
        request.customerDetails = customerDetails()
        val details = ItemDetails(id,name,price,qty)
        val itemDetails = ArrayList<ItemDetails>()
        itemDetails.add(details)
        request.itemDetails
        val creditCart = CreditCard()
        creditCart.isSaveCard = false
        creditCart.authentication = CreditCard.AUTHENTICATION_TYPE_RBA
        request.creditCard = creditCart
        return request

    }
    private fun customerDetails (): CustomerDetails? {
        val cd = CustomerDetails()
       // cd.address
        cd.email
       // cd.name
        cd.phone
        return cd
    }

    override fun onTransactionFinished(result: TransactionResult) {

        if (result.response != null) {
            val intent = Intent(applicationContext,DeskripsiTiketActivity::class.java)
            startActivity(intent)
            /*
            when (result.statusMessage) {
                TransactionResult.STATUS_SUCCESS -> {

                    Toast.makeText(
                        this,
                        "Transaction finish ID" + result.response.transactionId,
                        Toast.LENGTH_SHORT
                    ).show()

                    if(finishAfterTransition() !== null){
                        val intent = Intent(applicationContext,DataPemesananActivity::class.java)
                        startActivity(intent)
                    }



                }
                TransactionResult.STATUS_PENDING -> {
                    Toast.makeText(
                        this,
                        "Status pending ID" + result.response.transactionId,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TransactionResult.STATUS_FAILED -> {
                    Toast.makeText(
                        this,
                        "Status failde ID" + result.response.transactionId,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

             */
            result.response.validationMessages
        } else if (result.isTransactionCanceled) {
            Toast.makeText(this,"taraksaksi cancel",Toast.LENGTH_SHORT).show()
        }else{
            if (result.status.equals(TransactionResult.STATUS_INVALID)){
                Toast.makeText(this,"Transaction INVALID",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Transaction finisl FAILURE",Toast.LENGTH_SHORT).show()
            }
        }
    }

     */
}

