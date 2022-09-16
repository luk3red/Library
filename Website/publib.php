<?php

session_start();
$username = $_SESSION['var'];
$idlib = $_SESSION['var2'];


$newpage = 'http://localhost/svn/utente.php';

$auth_data = array(
'idlib'	=> $idlib,
'username' => $username
	);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/PubLib');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($auth_data));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

	if($response == 'true') {
	echo 'LIBRERIA PUBBLICATA <br>';
	header('Refresh: 5; url=' . $newpage);
	} else { echo "ERRORE"; }

?>
