<?php

session_start();
$username = $_SESSION['var'];
$idlib= $_SESSION['var2'];

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
<center><h1>Inserisci l'id della risorsa che vuoi eliminare</h1></center>
<form action="http://localhost/mioserver/modmediac.php" method="post">

<div>
	<center>
    <label for="uname"><b>ID</b></label>
    <input type="text" placeholder="Inserisci ID" name="id_media" required>

    <button type="submit">ELIMINA</button>
	</center>
  </div>
</form>
</body>
</html>

