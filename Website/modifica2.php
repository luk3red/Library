<?php
session_start();
include_once("postReview.php");
include_once("check_input.php");
include_once("callAPI.php");

$id = check_input($_POST['id']);

$username = $_SESSION['var'];
$_SESSION['var2'] = $id;


//echo "$username";
//echo "$id";



//GET

//.isset($_POST['lukered']
$get_data = callAPI('GET', 'http://localhost:8080/Library/WebServiceGet/Media/'.$id.'/'.$username,false, false);
$response = json_decode($get_data,true);
//echo "$get_data";
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

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>
<center><h1>Opzioni</1><center>
<div class="navbar">
  <a href="http://localhost/mioserver/utente.php">Home</a>
  <a href="http://localhost/mioserver/modnomelibreria.php">Modifica Nome Libreria</a>
  <a href="http://localhost/mioserver/publib.php">Pubblica Libreria</a>
  <a href="http://localhost/mioserver/creamedia.php">Aggiungi Risorsa</a>
  <a href="http://localhost/mioserver/media.php">Elimina Risorsa</a>
  </div>
</div>

<h3>Risorse</h3>


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
		<th>Nome</th>
    <th>Formato</th>
</tr>
</thead>
<tfoot>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>

</tr>
</tfoot>
<tbody>

<?php


    foreach($response as $result){
        ?>
		<form method="post">
        <tr>
	<td><input  type = "text" name = "ID" value = "<?php echo $result['id']; ?>" readonly></td>
            <td> <input  type = "text" name = "Nome" value = "<?php echo $result['nome']; ?>" readonly></td>
			<td> <input  type = "text" name = "Formato" value = "<?php echo $result['formato']; ?>" readonly></td>

        </tr>
		</form>
	<?php } ?>
</tbody>
</table>

</body>
</html>
