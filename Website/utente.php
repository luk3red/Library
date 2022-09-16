<?php
session_start();
$username = $_SESSION['var'];

include_once("callAPI.php");
$get_data = callAPI('GET', 'http://localhost:8080/Library/WebServiceGet/libpubb/', false, false);
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

<style>
.boxw {

}
</style>

<body>

<center><div class="boxw"><h1><img src='library.png' style="width: 500px; height: 200px; padding: 0px 0px 0px 0px"; /> </h1></div><center>
<div class="navbar">
  <a href="http://localhost/mioserver/utente.php">Home</a>
  <a href="http://localhost/mioserver/crealib.php">Crea Libreria</a>
  <a href="http://localhost/mioserver/crealibcond.php">Crea Libreria Condivisa</a>
  <a href="http://localhost/mioserver/tabella.php">Visualizza Librerie</a>
  <!--<a href="http://localhost/mioserver/tabellac.php">Visualizza Librerie Condivise da te</a>-->
  <a href="http://localhost/mioserver/tabellacw.php">Visualizza Librerie Condivise con te</a>
  <!--<a href="http://localhost/mioserver/modifica.php">Gestisci Libreria</a>
  <a href="http://localhost/mioserver/modificac.php">Gestisci Libreria Condivisa</a>-->
  <a href="http://localhost/mioserver/richiedi.php">Richiedi Libreria</a>
  <!--<a href="http://localhost/mioserver/tabellapr.php">Visualizza Prestiti</a>-->
  <a href="http://localhost/mioserver/tabellarichieste.php">Visualizza Richieste</a>
  <a href="http://localhost/mioserver/eliminalib.php">Elimina Libreria</a>
  <div class="dropdown">
  <button class="dropbtn" onclick="myFunction()">Modifica Profilo
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-content" id="myDropdown">
    <a href="http://localhost/mioserver/modana.php">Modifica Anagrafica</a>
    <a href="http://localhost/mioserver/moduser.php">Modifica Username</a>
    <a href="http://localhost/mioserver/modpass.php">Modifica Password</a>
  </div>
  </div>
</div>

<h3>Librerie Pubbliche</h3>

<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}


</script>

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
<th>ID_AMM</th>
<th>ID_Utente</th>
<th>Nome</th>
<th>Privacy</th>
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
<td>&nbsp;</td>
</tr>
</tfoot>

<tbody> 

<?php


    foreach($response as $result){
        ?>
		
        <tr>
	<td><input  type = "text" name = "ID" value = "<?php echo $result['id']; ?>" readonly></td>
            <td> <input  type = "text" name = "ID_AMM" value = "<?php echo $result['id_AMM']; ?>" readonly></td>
			<td> <input  type = "text" name = "ID_USER" value = "<?php echo $result['id_User']; ?>" readonly></td>
			<td><input  type = "url" name = "Nome" value = "<?php echo $result['nome']; ?>" readonly></td>
            <td><input  type = "text" name = "Privacy" value = "<?php echo $result['privacy']; ?>" readonly></td>
			<td><form action="http://localhost/mioserver/LibPub.php" method="post"> <input type="hidden" value = "<?php echo $result['id']; ?>" name="id_libreria" required><button type="submit">apri</button></td>

        </tr>
		</form>
	<?php } ?>
</tbody>
</table>

</body>
</html>
