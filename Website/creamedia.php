<?php
session_start();
$username = $_SESSION['var'];
$id = $_SESSION['var2'] ;

?>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
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
<form action="http://localhost/mioserver/creamedia2.php" method="post">
  <div class="container">
    <h1>Aggiungi Risorsa</h1>
    <p>Compila il form sottostante per aggiungere una risorsa</p>
    <hr>

    <label for="nome"><b>Nome Media</b></label>
    <input type="text" placeholder="Inserisci il tuo nome" name="nome" id="nome" required>

    <label for="versione"><b>Formato(txt,mp4,DVD...)</b></label>
    <input type="text" placeholder="Inserisci un formato" name="formato" id="formato" required>
    <hr>

    <button type="submit" class="registerbtn">Aggiungi risorsa</button>
  </div>
</form>

</body>
</html>
