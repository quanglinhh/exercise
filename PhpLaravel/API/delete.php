<?php
    header("Access-Control-Allow-Origin: *");
    header("Content-Type: application/json; charset=UTF-8");
    header("Access-Control-Allow-Methods:DELETE");
    header("Access-Control-Max-Age:3600");
    header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers,
        Authorization, X-Requested-With");
    
        include_once 'database.php';
        include_once 'employees.php';

        $database = new Database();
        $db = $database->getConnections();

        $item = new Employee($db);

        $data = json_decode(file_get_contents("php://input"));
        $item->$id = $data->id;

        if($item -> deleteEmployee()){
            echo json_encode("Employees deleted");
        }else{
            echo json_encode("Database could not be deleted");
        }

?>