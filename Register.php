<?php
    $con = mysqli_connect("localhost", "root", "", "pebbles");

    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "INSERT INTO user (name, username, age, password) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "siss", $name, $username,$age, $password);
    mysqli_stmt_execute($statement);

    mysqli_stmt_close($statement);
	mysqli_close($con);

    echo json_encode($response);
?>
