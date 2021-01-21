<?php
include_once('koneksi.php');

if(!empty(['asal']) && !empty($_GET['tujuan']) && !empty(['tanggal_keberangkatan'])){
	$asal = $_GET['asal'];
	$tujuan = $_GET['tujuan'];
	$tanggal_keberangkatan = $_GET['tanggal_keberangkatan'];
$query = "SELECT * from keberangkatan where tujuan = '$tujuan' && asal ='$asal' && tanggal_keberangkatan ='$tanggal_keberangkatan'";
}else{
	$query = "SELECT * from keberangkatan";
}
$get = mysqli_query($connect, $query);
$data = array();

if(mysqli_num_rows($get) > 0) {
	while($row = mysqli_fetch_assoc($get)){
		$data[] = $row;
	}
	set_response(true,"data behasil di ambil",$data);
}else{
	set_response(false,"data gagal di ambil",$data);
}

function set_response($isSuccess, $message, $data){
	$result = array(
		'isSuccess'=>$isSuccess,
		'message'=>$message,
		'data'=>$data);

	echo json_encode($result);
}


?>