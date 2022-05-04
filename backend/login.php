

<?php


$conn = mysqli_connect('localhost', 'root', '', 'embracedb');
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
  }
  echo "Connected successfully";

$sql="SELECT * FROM user";

$result=mysqli_query($conn, $sql);

$users = mysqli_fetch_all($result, MYSQLI_ASSOC);

print_r($users);


?>