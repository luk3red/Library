<?php

session_start();
$username = $_SESSION['var'];
//echo "$username";

include("check_input.php");

$nomelibreria = check_input($_POST['nomelibreria']);
//echo "$nomeprogetto";
$auth_data = array(
'username' 	=> $username,
'nomelibreria' 	=> $nomelibreria,
	);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/CreaLibCond');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($auth_data));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true') echo 'Libreria creata con successo!';
else echo 'Errore';

?>
