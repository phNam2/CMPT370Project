<?php
	require "370_database4.php";
	$Review = $_POST["Review"];
	$mysql_qu = "insert into Review (idProperty, Review, Rating, idTenants) VALUES (1, '$Review', 5,1)";
	$result = mysqli_query($conn, $mysql_qu);
	
	if ($result) {
		echo "\n Insert successed";
	}
	else {
		echo "\n Insert failed";
	}
?>