<?php
include_once("config.php");
global $mysqli;
if(isset($_POST['update'])){

    $id = $_POST['id'];

    $name = $_POST['name'];
    $mobile = $_POST['mobile'];
    $email = $_POST['email'];

    //update len database
    $result = mysqli_query($mysqli,"UPDATE Student SET name = '$name',email = '$email', mobile = '$mobile' WHERE id = '$id'");

    //Quay ve khi cap nhat xong
    header("Location: index.php");
}
?>
<?php
// lay id tu URL
$id = isset($_GET['id']);
// fetech du lieu theo id
$result = mysqli_query($mysqli,"SELECT * FROM Studentt WHERE id ='$id'");

while($stu_data = mysqli_fetch_array($result)){
    $name = $stu_data['NAME'];
    $email = $stu_data['email'];
    $mobile = $stu_data['mobile'];
}

?>
<html>
<Title>Update student information</title>
<body>
<form name="update_student" method ="post" action="edit.php">
    <table border="1">
        <tr>
            <td>Name</td>
            <td><input type"text" name ="name" value=<?php echo $name;?>/></td></tr>
        <tr>

        <tr>
            <td>Email</td>
            <td><input type"text" name ="email" value=<?php echo $email;?>/></td></tr>
        <tr>

        <tr>
            <td>Mobile</td>
            <td><input type"text" name ="mobile" value=<?php echo $mobile;?>/></td></tr>
        <tr>
            <td><input type"hidden" name="id" value=<?php echo $_GET['id'];?>/></td>
            <td><input type"submit" name="update" value="update"></td>
        </tr>
    </table>
</form>
</body>
</html>
