<?php

	$con = mysqli_connect("localhost","root","","pebbles");

	$password = $_POST["password"];
	$username = $_POST["username"];
	$sql_query="select  *  from user where username like'$username' and password like '$password';";
	$result=mysqli_query($con,$sql_query);
	$response=array();
while($row=mysqli_fetch_array($result))
{
	array_push($response,array("name"=>$row[0],"username"=>$row[1],"password"=>$row[3],"age"=>$row[2]));
	
}
	echo json_encode(array("user"=>$response));
	mysqli_close($con);
?>