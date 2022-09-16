<?php
session_start();
include_once("postReview.php");
include_once("check_input.php");


$username = check_input($_POST['username']);
$password = check_input($_POST['password']);

$_SESSION['var'] = $username;


$auth_data = array(
'username' 	=> $username,
'password' 	=> $password,
	);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/LogInAmm');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($auth_data));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

	if($response == 'true') {
	header("location: http://localhost/mioserver/amministratore.php");
	} else { echo "ERRORE NELLA VALIDAZIONE DEL LOGIN"; }


?>
