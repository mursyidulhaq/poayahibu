import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.Default
import com.mursyidul.poayah.model.pemesanan.dataPemesan.getDataPemesanan.Gallery
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class ApiConfig{

    companion object {

        // base url dari end point.
        const val BASE_URL = "http://192.168.43.151/PoAyah/pemesanan/"
        const val IMAGE_URL = BASE_URL+"image/"

    }

    // ini retrofit
    private fun retrofit() : Retrofit{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    // buat sebuah instance untuk call sebuah interface dari retrofit.
    fun instance() : ApiInterface {

        return retrofit().create(ApiInterface::class.java)

    }


}

// interface dari retrofit
interface ApiInterface{


    @Multipart
    @POST("insertDataPemesanan.php") // end point dari upload
    fun upload(
            @Part imagename:MultipartBody.Part,
            @Part ("nama_pemesan") nama_pemesan :RequestBody,
            @Part ("nohp_pemesan")nohp_pemesan :RequestBody,
            @Part ("jenis_kelamin")jenis_kelemin :RequestBody,
            @Part ("email_pemesan")email_pemesan :RequestBody


    ) : Call<Default> // memanggil response model 'Default'

    @GET("gallery.php") // end point untuk menampilkan semua data
    fun gallery() : Call<Gallery> // memanggil response model 'Gallery'

    @GET("delete.php") // end point untuk menghapus data
    fun delete(

            @Query("imageid") imageid:String?

    ) : Call<Default> // memanggil response model 'Default'

}