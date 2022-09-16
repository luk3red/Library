<?php

/* Bisogna creare una funzione che esegue le chiamate come le post, le get eccetera
 * dopodiché bisogna inserirla nello script php che useremo. A seconda del metodo vengono settate le opzioni */
 
 function callAPI($method, $url, $data, $headers) {
		$curl = curl_init();
		switch($method) {
			
			case "POST":
				curl_setopt($curl, CURLOPT_URL, $url);
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
				curl_setopt($curl, CURLOPT_POST, 1);
				if($data) 
					curl_setopt($curl, CURLOPT_POSTFIELDS);
			break;
			
			case "PUT":
				curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "PUT");
				if($data)
					curl_setopt($curl, CURLOPT_POSTFIELDS, $data);
			break;
			
			case "GET":
			curl_setopt($curl, CURLOPT_URL, $url);
			curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
			break;
			
			default:
			if($data)
				$url = sprintf("%s?%s", $url, http_build_query($data));
		
		}
		//OPZIONALE, si va a settare l'header per dire se stiamo mandando roba in json
		/*if(!$headers) curl_setopt($curl, CURLOPT_HTTPHEADER, array('APIKEY: 111111111111111111111', 'Content-Type: application/json'));
		else curl_setopt($curl, CURLOPT_HTTPHEADER, array('APIKEY, 111111111111111111111', 'Content_Type: application/json', $headers));*/
		
		/* Questa parte indica che c'è un messaggio di ritorno e dice il meccanismo di autenticazione che stiamo utilizzando
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
		curl_setopt($curl, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);*/
		
		$result = curl_exec($curl);
		if(!$result) die("Connection Failure");
		curl_close($curl);
		return $result;
	}
?>