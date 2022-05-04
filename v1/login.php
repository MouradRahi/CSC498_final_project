

<?php


include('/../includes/DbOperations.php');


$response = [];

if ($_SERVER['REQUEST_METHOD']=='POST'){

  if (isset($_POST['email']) and isset($_POST['user_password'])){
    $db = new DbOperation();
    if($db->userLogin($_POST['email'],$_POST['user_password'])){
      $user = $db->getUserByEmail($_POST['email']);
      $response['error']= false;
      $response ['id']=$user['id']
      $response ['email']=$user['email']
    }
    else{
      $response ['error']=true;
      $response['message']="Insert correct values";
    }
  }
  else{
    $response ['error']=true;
    $response['message']="Insert correct values";
  }
}

echo json_encode($response);

/*$conn = mysqli_connect('localhost', 'root', '', 'embracedb');
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
  }
  echo "Connected successfully";

$sql="SELECT * FROM user";

$result=mysqli_query($conn, $sql);

$users = mysqli_fetch_all($result, MYSQLI_ASSOC);

print_r($users);*/


?>