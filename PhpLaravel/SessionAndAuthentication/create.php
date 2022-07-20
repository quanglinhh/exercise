<?php
//Kiểm tra xem form có submit
if(isset($_POST["submit"])/*!empty($_POST)*/){
    $name = $_POST['name'];
    $email = $_POST['email'];
    $mobile = $_POST['mobile'];
    echo "$name,$email,$mobile";

    //Load đối tượng connection
    include_once("config.php");
    global $mysqli;
    //Thêm bản ghỉ
    $result = mysqli_query($mysqli, "INSERT INTO students(name,email,mobile) VALUES ('$name','$email','$mobile')");

    //Hiển thị sau khi add thành công
    echo"User added successfully";
}else{
    echo "Khong tao duoc";
}
?>
<html >
<head>
    <title>Add Student</title>
</head>
<body>
    <a href="index.php">Go to home</a>
    <br/><br/>

    <form action="create.php" method="post" name = "form">
        <table width="25%" border="0">
            <tr>
                <td>Name</td>
                <td><input type="text" name ="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name ="email"></td>
            </tr>
            <tr>
                <td>Mobile</td>
                <td><input type="text" name ="mobile"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="submit" value="Add" /></td>

            </tr>
        </table>
    </form>
</body>
</html>
