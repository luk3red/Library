<?php

session_start();
$username = $_SESSION['var'];

include("check_input.php");
include("check_email.php");
include("check_cf.php");

$password = check_input($_POST['password']);

$newpage = 'http://localhost/mioserver/moduser.php';


/*if(chkEmail($email)==true) {
	echo 'Indirizzo email corretto';
}
else {
	echo 'Indirizzo email errato <br>';
	header('Refresh: 5; url=' . $newpage);
	echo 'Tra 5 secondi verrai reindirizzato. Se non vuoi aspettare <a href="' . $newpage . '">clicca qui</a>';
}*/


$data_array= array(
  'username' 	=> $username,
  'password'=> $password,
);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/mioserver/WebServicePost/ModPass');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($data_array));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true'){ echo 'Modifica effettuata con successo!'; header('Refresh: 5; url=http://localhost/mioserver/utente.html');
}else{
	echo 'Errore';
	header('Refresh: 5; url=' . $newpage);
	echo 'Tra 5 secondi verrai reindirizzato. Se non vuoi aspettare <a href="' . $newpage . '">clicca qui</a>';
}



?>
