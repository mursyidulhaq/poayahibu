<?php
include_once('koneksi.php');
if(!empty($_POST['id_keberangkatan']) && !empty($_POST['asal']) && !empty($_POST['tujuan']) && !empty($_POST['poasal']) && !empty($_POST['potujuan']) && !empty($_POST['harga']) && !empty(['tanggal_keberangkatan']) && !empty($_POST['jumlah_tiket']) ){
   $id_keberangkatan = $_POST['id_keberangkatan'];
    $asal = $_POST['asal'];
    $tujuan = $_POST['tujuan'];
    $poasal = $_POST['poasal'];
    $potujuan = $_POST['potujuan'];
    $harga = $_POST['harga'];
    $tanggal_keberangkatan = $_POST['tanggal_keberangkatan'];
    $jumlah_tiket = $_POST['jumlah_tiket'];


$query = "UPDATE keberangkatan set asal = '$asal',tujuan ='$tujuan',poasal='$poasal',potujuan='$potujuan',harga='$harga',tanggal_keberangkatan='$tanggal_keberangkatan',jumlah_tiket='$jumlah_tiket'where id_keberangkatan = '$id_keberangkatan'";
$update = mysqli_query($connect, $query);
if($update){
	set_response(true,"update berhasil ");
}else{
	set_response(false,"update gagal");
}
}else{
	set_response(false,"data masih ada yang kosong, data harus diinputkan");
}

function set_response($isSuccess, $message){

	$result = array(

		'isSuccess'=>$isSuccess,
		'message'=>$message);

	echo json_encode($result);
}
