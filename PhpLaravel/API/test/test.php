<?php
    echo "Superglobal in PHP<br>";
   

    $email = htmlspecialchars($_POST['email'] ?? ' ') ;
    $password = $_POST['password'] ?? ' ';
    echo $email ;
    echo $password;
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
       <input type="text" name ="email"> 
    </div>
    <div class="">
        <label for="password">Password: </label>
        <input type="password" name ="password"> 
    </div>
    <input type="submit" value="submit">    
</form>
</body>
<script>alert('Hacked Password');</script>
</html>