
<?php

include('/../includes/DbOperations.php');


$response = [];

if ($_SERVER['REQUEST_METHOD']=='POST'){

    $db = new DbOperation();
    if($db->checkUserProfile($_POST['email'])){
        echo true;
    }
    if (isset($_POST['email']) and isset($_POST['name']) and isset($_POST['willing_call']) and isset($_POST['number']) ){
        $db = new DbOperation();
        if($db->userProfileUpdate($_POST['email'],$_POST['name'],$_POST['willing_call'],$_POST['number'])){
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


?>