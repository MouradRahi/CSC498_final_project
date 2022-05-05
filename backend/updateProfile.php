<?php

require __DIR__ . '/classes/Database.php';
$db_connection = new Database();
$conn = $db_connection->dbConnection();

$email = $_POST["email"];
$name = $_POST["name"];
$description = $_POST["description"];
$willing =intval( $_POST["willing"]);

if ($willing === 0) {
    $number = 0 ;
}else {
    $number = intval($_POST["number"]);
}

$query = $conn-> prepare("UPDATE users SET name= $name , willing_call = $willing , number= $number , description=$description WHERE email= $email");

$query-> execute();


?>