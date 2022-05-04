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
    function createUser($email, $user_password){
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
}