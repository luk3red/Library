<?php

function postReview($auth_data, $url) {

	$curl = curl_init();
	curl_setopt($curl, CURLOPT_POST, 1);
	curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($auth_data));
	curl_setopt($curl, CURLOPT_URL, $url); 
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($curl, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);
	$result = curl_exec($curl);
	if(!$result) { die ("Connectione Failure"); }
	curl_close($curl);
	return $result;
}

?>