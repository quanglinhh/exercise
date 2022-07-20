<?php
 include_once("config.php");

    if(isset($_POST['update'])){

        $id = $_POST['id'];
    
        $name = $_POST['name'];
        $mobile = $_POST['mobile'];
        $email = $_POST['email'];

            //update len database
    $result = mysqli_query($mysqli,"UPDATE Student SET name = '$name',email = '$email', mobile = '$mobile' WHERE id = $id");

    //Quay ve khi cap nhat xong
    header("Location: index.php");
    }
?>
<?php
// lay id tu URL
    $id = $_GET['id'];
// fetech du lieu theo id
    $result = mysqli_query($mysqli,"SELECT * FROM Studentt WHERE id =$id");

    while($stu_data = mysqli_fetch_array($result)){
        $name = $stu_data['NAME'];
        $email = $stu_data['email'];
        $mobile = $stu_data['mobile'];
    }

?>
<html>  
     <title> Edit Student</title>
    <body>
        <a href="index.php" >Home</a>
        <br><br>
        <form  name="update_studient" method="POST" action="edit.php">
        <table border="0">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value=<?php echo $name ;?>></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value=<?php echo $email ;?>></td>
            </tr>
            <tr>
                <td>Mobli</td>
                <td><input type="text" name="mobile" value=<?php echo $mobile; ?>></td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" value=<?php echo $_GET['id'];?>></td>
                <td><input type="submit" name="update" value="Update"></td>
            </tr>
        </table>
        </form>
    </body>
</html>