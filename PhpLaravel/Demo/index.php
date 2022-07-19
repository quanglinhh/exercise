
<?php
include_once("config.php");
global $mysqli;
$result = mysqli_query($mysqli,"SELECT * FROM student ORDER BY id DESC");
?>
<html>
<body>
<table width='80%' border=1>
    <tr>
        <th>Name</th> <th>Email</th> <th>Phone</th> <th>Options</th>
    </tr>
    <?php

    while($stu_data = mysqli_fetch_array($result))
    {
        echo "<tr>";
        echo "<td>". $stu_data['NAME'] ."</td>";
        echo "<td>". $stu_data['email'] . "</td>";
        echo "<td>". $stu_data['mobile'] . "</td>";
        echo "<td>";
        echo "</tr>";
    }
    ?>

</table>
</body>
<html>