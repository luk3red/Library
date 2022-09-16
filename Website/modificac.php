<?php

session_start();
$username = $_SESSION['var'];

?>

<html>
<center><h1>Inserisci l'id della libreria condivisa che vuoi gestire</h1></center>
<form action="http://localhost/mioserver/modificac2.php" method="post">

<div>
	<center>
    <label for="uname"><b>ID Libreria</b></label>
    <input type="text" placeholder="Inserisci ID" name="id" required>

    <button type="submit">MODIFICA</button>
	</center>
  </div>
</form>
</html>
