<?php
$con = mysqli_connect("localhost","root","","pebbles");
$username=$_POST["username"];
$password=$_POST["password"];
$sql_query="DELETE from user WHERE username like '$username' and password like '$password';";
if(mysqli_query($con,$sql_query)){
echo"User deleted";
}
else
{
echo"error".mysqli_error();
}
?>