<?php


class connect{
  private $con;

    function __construct (){
        
    }
    function Connect(){
      require_once dirname(__FILE__).'/constants.php';
      $this->con=new msqli(DB_HOST,DB_USER,DB_PASSWORD,DB_NAME);
      if (mysqli_connect_errno()) {
        echo "failed".mysqli_connect_err();
      }
      return $this->con;
    }
}
/*$conn = mysqli_connect('localhost', 'root', '', 'embracedb');

if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
echo "Connected successfully";*/
?>