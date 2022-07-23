<?php
    header("Access-Control-Allow-Origin: *");
    header("Content-Type: application/json; charset=UTF-8");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Max-Age: 3600");
    header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers,
    Authorization, X-Requested-With");
    include_once 'database.php';
    include_once 'employee.php';
    $database = new Database();
    $db = $database->getConnections();
    $item = new Employee($db);  
    $data = json_decode(file_get_contents("php://input"));
    $item->name = $data->name;
    $item->email = $data->email;
    $item->age = $data->age;
    $item->designation = $data->designation;
    $item->created =date('Y-m-d H:i:s');
    if($item->createEmployees()){
        echo'Employee created successfully';

    }else{
        echo'Employee could not be created';
    }    
?>