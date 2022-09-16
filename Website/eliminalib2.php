<?php
session_start();
$username = $_SESSION['var'];

include("check_input.php");
$id = check_input($_POST['id']);

$data_array= array(

  'id'=> $id,
  'username'=> $username,
);

$cURL = curl_init();

curl_setopt($cURL, CURLOPT_URL, 'http://localhost:8080/Library/WebServicePost/EliminaLib');
curl_setopt($cURL, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($cURL, CURLOPT_POSTFIELDS, json_encode($data_array));
curl_setopt($cURL, CURLOPT_HTTPHEADER, array('Content-Type: application/json') );
curl_setopt($cURL, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($cURL);
curl_close($cURL);

if($response == 'true') echo "success";
else echo "Errore";

?>
