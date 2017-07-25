<?php
$host="localhost";
$user="root";
$pass="";
$db_name="pebbles";
$query="select  *  from user  ;";
$con=mysqli_connect($host,$user,$pass,$db_name);
$result=mysqli_query($con,$query);
$response=array();
while($row=mysqli_fetch_array($result))
{
	array_push($response,array("name"=>$row[0],"username"=>$row[1],"password"=>$row[3],"age"=>$row[2]));
	
}
echo json_encode(array("user"=>$response));


mysqli_close($con);



?>