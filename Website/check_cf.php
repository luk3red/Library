<?php
function chKcf($cf){
     if($cf=='')
	return false;

     if(strlen($cf)!= 16)
	return false;

    return true;
}
?>
