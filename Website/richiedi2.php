<?php
session_start();
$username = $_SESSION['var'];
//$id = $_SESSION['var2'] ;
include("check_input.php");


$ID_libreria = check_input($_POST['id_libreria']);




/*if(chkEmail($email)==true) {
	echo 'Indirizzo email corretto';
}
else {
	echo 'Indirizzo email errato <br>';
	header('Refresh: 5; url=' . $newpage);
	echo 'Tra 5 secondi verrai reindirizzato. Se non vuoi aspettare <a href="' . $newpage . '">clicca qui</a>';
}*/


$data_array= array(
  'ID_libreria' 	=> $ID_libreria,
  'username' => $username
);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/Richiedi');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($data_array));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true'){ echo "Hai richiesto la libreria"; header( "Refresh:5; url=http://localhost/mioserver/utente.php", true, 303);}
else if($response == 'false1'){
echo "Non esiste una libreria pubblica con questo id oppure c'è stato un errore nell'inserimento \n verrai reindirizzato tra 5 secondi";
header( "Refresh:5; url=http://localhost/mioserver/utente.php", true, 303);}
else if($response == 'false2'){
	echo "Hai già fatto questa richiesta \n verrai reindirizzato tra 5 secondi";
header( "Refresh:5; url=http://localhost/mioserver/utente.php", true, 303);
}
//header( "Location: http://localhost/mioserver/utente.php");




?>
