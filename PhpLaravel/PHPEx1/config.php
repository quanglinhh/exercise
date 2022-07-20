<?php
$user = "root";
$pass = "";
$db = "mypro_crud";
$mysqli = new mysqli("localhost", $user, $pass, $db);
if ($mysqli->connect_errno )
{
    die( "Couldn't connect to MySQL" );
};
?>