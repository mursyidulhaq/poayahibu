<?php
include_once('koneksi.php');
if(!empty($_POST['id_bus']) && !empty($_POST['jenis_mobil']) && !empty($_POST['merek_mobil']) && !empty($_POST['nama_supir']) ){
   $id_bus = $_POST['id_bus'];
    $jenis_mobil = $_POST['jenis_mobil'];
    $merek_mobil = $_POST['merek_mobil'];
    $nama_supir = $_POST['nama_supir'];
    
$query = "UPDATE bus set jenis_mobil = '$jenis_mobil',merek_mobil ='$merek_mobil',nama_supir='$nama_supir' where id_bus= '$id_bus'";
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
