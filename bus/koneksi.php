<?php
$hostname ="localhost";
$username ="root";
$password ="";
$database ="poayah";

$connect =mysqli_connect($hostname, $username, $password, $database);

if(mysqli_connect_errno()){

/* echo "gagal connect to database:" .*/mysqli_connect_error();die();
}else{
 //echo "berhasil connect to datbase";
}




?>