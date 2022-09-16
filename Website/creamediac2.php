<?php
session_start();
$username = $_SESSION['var'];
$id = $_SESSION['var2'] ;
include("check_input.php");


$nome = check_input($_POST['nome']);
$formato = check_input($_POST['formato']);



/*if(chkEmail($email)==true) {
	echo 'Indirizzo email corretto';
}
else {
	echo 'Indirizzo email errato <br>';
	header('Refresh: 5; url=' . $newpage);
	echo 'Tra 5 secondi verrai reindirizzato. Se non vuoi aspettare <a href="' . $newpage . '">clicca qui</a>';
}*/


$data_array= array(
  'nome' 	=> $nome,
  'formato'=> $formato,
  'id' => $id,
  'username' => $username,
);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/CreaMediaC');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($data_array));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true'){ echo "Hai aggiunto una risorsa"; header('Location: http://localhost/mioserver/utente.php');}
else { echo "Erroe";}



?>
