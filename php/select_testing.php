<?php
	require "370_database4.php";
	$Fna = $_POST["Fna"];
	$Lna = $_POST["Lna"];
	$mysql_qu = "SELECT * FROM Applicants where Fname like '$Fna' and LName like '$Lna';";
	$result = mysqli_query($conn, $mysql_qu);
	
	if (mysqli_num_rows($result) > 0) {
		echo "\n Connect successfull";
	}
	else {
		echo "\n Connect unsuccessfull";
	}
?>