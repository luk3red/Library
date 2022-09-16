<?php

session_start();
$username = $_SESSION['var'];
//echo "$username";
include_once("callAPI.php");

//GET

//.isset($_POST['lukered']
$get_data = callAPI('GET', 'http://localhost:8080/Library/WebServiceGet/Richieste/'.$username, false, false);
$response = json_decode($get_data, true);


?>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
  overflow: hidden;
  background-color: #333;
  font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}
</style>
</head>
<body>
<div class="navbar">
  <a href="http://localhost/mioserver/utente.php">Home</a>
  </div>



<head>
<style>
table.redTable {
  background-color: #FFFFFF;
  width: 100%;
  text-align: center;
  border-collapse: collapse;
}
table.redTable td, table.redTable th {
  border: 1px solid #AAAAAA;
  padding: 3px 2px;
}
table.redTable tbody td {
  font-size: 13px;
}
table.redTable tr:nth-child(even) {
  background: #E9E9E9;
}
table.redTable thead {
  background: #000000;
  background: -moz-linear-gradient(top, #404040 0%, #191919 66%, #000000 100%);
  background: -webkit-linear-gradient(top, #404040 0%, #191919 66%, #000000 100%);
  background: linear-gradient(to bottom, #404040 0%, #191919 66%, #000000 100%);
}
table.redTable thead th {
  font-size: 19px;
  font-weight: bold;
  color: #FFFFFF;
  text-align: center;
  border-left: 2px solid #000000;
}
table.redTable thead th:first-child {
  border-left: none;
}

table.redTable tfoot {
  font-size: 13px;
  font-weight: bold;
  color: #00000;
  background: #000000;
  background: -moz-linear-gradient(top, #404040 0%, #191919 66%, #000000 100%);
  background: -webkit-linear-gradient(top, #404040 0%, #191919 66%, #000000 100%);
  background: linear-gradient(to bottom, #404040 0%, #191919 66%, #000000 100%);
}
table.redTable tfoot td {
  font-size: 13px;
}
</style>
</head>
<table class="redTable">
<thead>
<tr>
		<th>ID</th>
        <th>ID richiedente</th>
		<th>ID libreria</th>
		<th>ID proprietario</th>
		<th></th>
</tr>
</thead>
<tfoot>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>

</tr>
</tfoot>

<tbody>

<?php


    foreach($response as $result){
        ?>
		
        <tr>
			<td><input  type = "text" name = "ID" value = "<?php echo $result['id']; ?>" readonly></td>
            <td> <input  type = "text" name = "ID_richiedente" value = "<?php echo $result['id_richiedente']; ?>" readonly></td>
			<td> <input  type = "text" name = "ID_libreria" value = "<?php echo $result['id_libreria']; ?>" readonly></td>
			<td><input  type = "text" name = "ID_owner" value = "<?php echo $result['id_owner']; ?>" readonly></td>
			<td><form action="http://localhost/mioserver/Permesso.php" method="post"> <input type="hidden" value = "<?php echo $result['id_richiedente']; ?>" name="id_richiedente" required> 
			<input type="hidden" value = "<?php echo $result['id_libreria']; ?>" name="id_libreria" required>
			<input type="hidden" value = "<?php echo $result['id_owner']; ?>" name="id_owner" required>
			<button type="submit">ACCETTA</button></form></td>
			

        </tr>
		</form>
	<?php } ?>
</tbody>
</table>

</body>
</html>
