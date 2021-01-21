<?php
include_once('koneksi.php');

if(!empty($_GET['id_bus'])){
	$id_bus = $_GET['id_bus'];
$query = "SELECT * from bus where id_bus = '$id_bus'";
}else{
	$query = "SELECT * from bus";
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