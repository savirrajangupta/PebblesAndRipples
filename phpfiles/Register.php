<?php
    
$con = mysqli_connect("localhost", "root", "", "pebbles");


    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $password = $_POST["password"];


  $sql_query="insert into user values('$name','$username','$age','$password');";
if(mysqli_query($con,$sql_query)){
	


    echo"done";

}
else
{
echo"error".mysqli_error();
}
?>
