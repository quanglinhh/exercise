<?php
include_once("config.php");
global $mysqli;
//Trả về true nế người dùng nhấn submit(update_studient);
if(isset($_POST["update"]))
{
    $id = $_POST["id"];
    $name = $_POST["name"];
    $mobile = $_POST["mobile"];
    $email = $_POST["email"];

    $result = mysqli_query($mysqli,"UPDATE students SET name = '$name', email = '$email', mobile = '$mobile' WHERE id = '$id'");

    //Quay về trang chủ nếu cập nhật xong
    header("Location: index.php");
}
?>
<?php
//Lấy id từ URL
$id = $_GET["id"];

//fetech dữ liệu theo id
$result = mysqli_query($mysqli, "SELECT * FROM students WHERE id = $id");

while ($user_data = mysqli_fetch_array($result)) {
    $name = $user_data["name"];
    $email = $user_data["email"];
    $mobile = $user_data["mobile"];
}

?>
<html>
    <head>
        <title>Edit Student</title>
    </head>
    <body>
    <a href="index.php">Home</a>
    <br/><br/>
    <form name ="update_student" method ="POST" action ="edit.php">
        <table border=0>
            <tr>
                <td>Name</td>
                <td><input type="text" name ="name" value=<?php echo $name;?>></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name ="email" value=<?php echo $email;?>></td>
            </tr>
            <tr>
                <td>Mobile</td>
                <td><input type="text" name ="mobile" value=<?php echo $mobile;?>></td>
            </tr>
            <tr>
                <td><input type=hidden" name ="id" value=<?php echo $_GET['id'];?>></td>
                <td><input type="submit" name = "update" value="Update"/></td>
            </tr>
        </table>
    </form>
    </body>
</html>

