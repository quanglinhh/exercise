<?php
    include_once("config.php");
    global $mysqli;
    $id = $_GET['id'];

    $result = mysqli_query($mysqli,"DELETE FROM students WHERE id = '$id'");
    header("Location: index.php");

?>