<?php
session_start();
include_once("postReview.php");
include_once("check_input.php");
include_once("callAPI.php");

$id_media= check_input($_POST['id_media']);

$username = $_SESSION['var'];
$idlib = $_SESSION['var2'];
$_SESSION['var3'] = $id_media;

//echo "$idprog";
//echo "$id_sorg";



//POST
$auth_data = array(
'id_media' 	=> $id_media,
'idlib'	=> $idlib,
	);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/EliminaMedia');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($auth_data));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true') echo "success";
else echo "Errore";

?>
<html>
<body>

</body>
</html>
