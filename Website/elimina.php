<?php

include("check_input.php");
//include("check_email.php");
//include("check_cf.php");

$cf = check_input($_POST['cf']);

//$newpage = 'http://localhost/svn/registrazione.html';


/*if(chkEmail($email)==true) {
	echo 'Indirizzo email corretto';
}
else {
	echo 'Indirizzo email errato <br>';
	header('Refresh: 5; url=' . $newpage);
	echo 'Tra 5 secondi verrai reindirizzato. Se non vuoi aspettare <a href="' . $newpage . '">clicca qui</a>';
}*/


$data_array= array(
  'cf'=> $cf
);

//if(chkEmail($email) == true && chKcf($cf))
//{

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/Elimina');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($data_array));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true') echo "Utente eliminato!";
else echo "Errore";
/*}else{
	echo 'Controlla indirizzo Email o il Codice Fiscale <br>';
	header('Refresh: 5; url=' . $newpage);
	echo 'Tra 5 secondi verrai reindirizzato. Se non vuoi aspettare <a href="' . $newpage . '">clicca qui</a>';*/
//}



?>
