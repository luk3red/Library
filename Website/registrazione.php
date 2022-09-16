<?php
session_start();
include("check_input.php");
include("check_email.php");
include("check_cf.php");

$username = check_input($_POST['username']);
$_SESSION['var'] = $username;
$password = check_input($_POST['password']);
$cf = check_input($_POST['cf']);
$nome = check_input($_POST['nome']);
$cognome = check_input($_POST['cognome']);
$email = check_input($_POST['email']);

$newpage = 'http://localhost/mioserver/registrazione.html';


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
  'cf'=> $cf,
  'nome' 	=> $nome,
  'cognome'=> $cognome,
  'email'=> $email
);

if(chkEmail($email) == true && chKcf($cf))
{

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/Registrazione');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($data_array));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true') header('Location: http://localhost/mioserver/utente.php');
else "Erroe nella registrazione";
}else{
	echo 'Controlla indirizzo Email o il Codice Fiscale <br>';
	header('Refresh: 5; url=' . $newpage);
	echo 'Tra 5 secondi verrai reindirizzato. Se non vuoi aspettare <a href="' . $newpage . '">clicca qui</a>';
}



?>
