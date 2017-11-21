<?php
	require "370_database4.php";
	$property_id = $_POST["property_id"];
	$mysql_qu = "select * from review where id='$property_id'";
	$result =$conn->query($mysql_qu);
	
	if ($result->num_rows > 0) {
    echo "<table><tr><th>ID</th><th>Name</th></tr>";
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>".$row["review"].</td></tr>"";
    }
    echo "</table>";
} else {
    echo "0 results";
}

?>