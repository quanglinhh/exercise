<?php
    echo "Sessions in PHP<br>";
    session_start();
    if(isset($_POST['submit'])) {
        $email = filter_input(INPUT_POST,'email',
                    FILTER_SANITIZE_SPECIAL_CHARS);
        $password = $_POST['password'];
        if($email == 'linh@gmail.com'
            && $password == '123456') {
                $_SESSION['email'] = $email;
            header('Location: cookies.php');

        }else{
            echo "Sai";
        }            
    }
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST">
        <div class="">
            <label for="name">Your email: </label>
            <input type="text" name="email">
        </div>
        <div class="">
            <label for="password">Password: </label>
            <input type="password" name="password">
        </div>
        <input type="submit" value="submit" name="submit" >
    </form>
</body>

</html>