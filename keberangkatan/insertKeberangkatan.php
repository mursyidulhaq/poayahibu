<?php
include_once('koneksi.php');
if(!empty($_POST['asal']) && !empty($_POST['tujuan']) && !empty($_POST['poasal']) && !empty($_POST['potujuan']) && !empty($_POST['harga']) && !empty(['tanggal_keberangkatan']) && !empty($_POST['jumlah_tiket']) ){
	 $asal = $_POST['asal'];
	 $tujuan = $_POST['tujuan'];
     $poasal = $_POST['poasal'];
     $potujuan = $_POST['potujuan'];
     $harga = $_POST['harga'];
     $tanggal_keberangkatan = $_POST['tanggal_keberangkatan'];
     $jumlah_tiket = $_POST['jumlah_tiket'];
	
$query = "INSERT into keberangkatan (asal,tujuan,poasal,potujuan,harga,tanggal_keberangkatan,jumlah_tiket) values ('$asal', '$tujuan', '$poasal','$potujuan','$harga','$tanggal_keberangkatan','$jumlah_tiket') ";
 $insert = mysqli_query($connect, $query);
 if($insert){
 	set_response(true,"insert data berhasil");
 }else{
 	set_response(false,"insert data gagal");
 }

}else{
	set_response(false,"data keberangkatan harus diinputka");
}

function set_response($isSuccess,$message){

$result = array(

'isSuccess'=>$isSuccess,
'message'=>$message);

echo json_encode($result);

}

?>