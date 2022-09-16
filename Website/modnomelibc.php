<?php

session_start();
include_once("check_input.php");


$nome = check_input($_POST['nome']);
$id_media = $_SESSION['var3'];
$idlib = $_SESSION['var2'];




$auth_data = array(
'nome' 	=> $nome,
'idlib' => $idlib,
	);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/Modnomelibc');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($auth_data));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

	if($response == 'true') {
	echo "HAI CAMBIATO NOME";
	} else { echo "ERRORE"; }

?>
