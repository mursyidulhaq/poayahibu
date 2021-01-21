<?php
include_once('koneksi.php');
if(!empty($_POST['id_bus'])){
	$id_bus = $_POST['id_bus'];
	$query = "DELETE from bus where id_bus = '$id_bus'";
	$delete =mysqli_query($connect, $query);
	if($delete){
		set_response(true,"delete berhasil");
	}else{
		set_response(false,"delete gagal");
	}
}else{
	set_response(false,"id harus di inputka");
}

function set_response($isSuccess, $message){
	$result = array(
		'isSuccess'=>$isSuccess,
		'message'=>$message);

	echo json_encode($result);
}

?>