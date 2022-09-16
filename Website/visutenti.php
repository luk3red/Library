<html>
<body>

<?php

include_once("callAPI.php");


//GET



$get_data = callAPI('GET', 'http://localhost:8080/Library/WebServiceGet/Utenti', false, false);
$response = json_decode($get_data, true);
//print_r($response);


?>

<table border="1">
<thead>
    <tr>

        <th>Codice Fiscale</th>
        <th>Nome</th>
		<th>Cognome</th>
		<th>Email</th>
        <th>UID</th>
		<th>Username</th>
		<th>Password</th>

    </tr>
</thead>
<tbody>

<?php


    foreach($response as $result){
        ?>
		<form method="post">
        <tr>
            <td><input  type = "text" name = "CF" value = "<?php echo $result["anagrafica"]['cf']; ?>" readonly></td>
            <td> <input  type = "text" name = "nome" value = "<?php echo $result["anagrafica"]['nome']; ?>" readonly></td>
			<td> <input  type = "text" name = "cognome" value = "<?php echo $result["anagrafica"]['cognome']; ?>" readonly></td>
			<td><input  type = "text" name = "email" value = "<?php echo $result["anagrafica"]['email']; ?>" readonly></td>
            <td> <input  type = "text" name = "uid" value = "<?php echo $result['uid']; ?>" readonly></td>
			<td><input  type = "text" name = "username" value = "<?php echo $result['username']; ?>" readonly></td>
            <td> <input  type = "text" name = "password" value = "<?php echo $result['password']; ?>" readonly></td>

        </tr>
		</form>
	<?php } ?>
</tbody>
</table>


</body>
</html>
