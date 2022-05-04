<?php

include('/../includes/DbOperations.php');


$response = [];

if ($_SERVER['REQUEST_METHOD']=='POST'){

    if (isset($_POST['email']) and isset($_POST['user_password'])){
        //opperate the data further
        $db = new DbOperation();

        if ($db->createUser($_Post['email'],$_POST['user_password'])){
            $response['error']=false;
            $response['message']='registration succesful';
        }
        else{
            $response['error']=true;
            $response["message"]="something went wrong";
        }

    }
    else{
        $response ['error']=true;
        $response['message']="Insert correct values";
    }

}
else{
    $response['error']=true;
    $response['message']="Invalid Request";
}
echo json_encode($response);
?>