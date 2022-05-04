<?php

class DbOperation{
    
    private $con;

    function __construct (){
        require_once dirname(__FILE__).'/connect.php';
        $db=new connect();
        $this->con = $db->Connect();
    }

    /*
    CRUD
    C->CREATE
    R->
    U->UPDATE
    D->DELETE
    */
    public function createUser($email, $user_password){
        $password=md5($user_password);
        $stmt=$this->con->prepare("INSERT INTO `user` (`id`, `email`, `user_password`,`name`, `willing_call`, `msg`, `number`) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
        $stmt->bind_param("ss",$email,$user_password);
        if ($stmt->execute()){
            return true;
        }
        else{
            return false;
        }
    }
    public function userLogin($email, $user_password){
        $password=md5($user_password);
        $stmt = $this->con->prepare("SELECT id FROM user WHERE email=? AND user_password=?");
        $stmt->bind_param("ss", $email,$password);
        $stmt->execute();
        $stmt->store_result();
        return $stmt->num_rows>0;
    }
    public function getUserByEmail($email){

        $stmt=$this->con->prepare("SELECT * FROM user WHERE email = ?");
        $stmt->bind_param("s",$email);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }

}
?>