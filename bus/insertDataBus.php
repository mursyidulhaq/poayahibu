<?php
include_once('koneksi.php');
if(!empty($_POST['jenis_mobil']) && !empty($_POST['merek_mobil']) && !empty($_POST['nama_supir'])){
  
     $jenis_mobil = $_POST['jenis_mobil'];
	 $merek_mobil = $_POST['merek_mobil'];
     $nama_supir = $_POST['nama_supir'];
    
$query = "INSERT into bus (jenis_mobil,merek_mobil,nama_supir) values ('$jenis_mobil', '$merek_mobil', '$nama_supir') ";
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