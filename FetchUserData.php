<?php
	$con = mysqli_connect("localhost","root","","pebbles");
	$password = $_POST["password"];
	$username = $_POST["username"];

	$statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
	mysqli_stmt_bind_param($statement,$username, $password);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$userID, $name, $age,$username, $password);

	$user = array();

	while(mysqli_stmt_fetch($statement)){
		$user[name] = $name;
		$user[age] = $age;
		$user[username] = $username;
		$user[password] = $password;
	}

	echojson_encode($user);

	mysqli_stmt_close($statement);
	mysqli_close($con);
?>
