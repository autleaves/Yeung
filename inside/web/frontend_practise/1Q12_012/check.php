<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PHP基礎</title>
</head>
<body>

<?php
$name=$_POST['name'];
$email = $_POST['email'];
$cou = $_POST['cou'];
$food = $_POST['food'];

$type_1 = 'ランチ';
$type_2 = 'ディナー'; 


$name=htmlspecialchars($name);
$email=htmlspecialchars($email);
$food=htmlspecialchars($food);

    print'name';
    print $email;
    print'<br>'; 
    print'Email';
    print $email;
    print'<br>'; 
    print'コース'; 
    if($cou == 1){
        print $type_1; 
    } else if ($cou == 2) {
        print $type_2;  
    }
    print'<br>'; 
    print'Food'; 
    print $food;
    print'<br>';   


// if($name=='' || $email=='' || $food==''){
//     print '<form>';
//     print '<input type="button" onclick="history.back()" value="戻る">';
//     print '</form>';
// } else {
//     print '<form method="post" action="thanks.php">';
//     print '<input name="nickname" type="hidden" value="'.$name.'">';
//     print '<input name="email" type="hidden" value="'.$email.'">';
//     if($cou == 1){
//         print '<input name="email" type="hidden" value="'.$type_1.'">'; 
//     } else if ($cou == 2) {
//         print '<input name="email" type="hidden" value="'.$type_2.'">'; 
//     }
//     print '<input name="goiken" type="hidden" value="'.$food.'">';
//     print '<input type="button" onclick="history.back()" value="戻る">';
//     print '<input type="submit" value="OK">';
//     print '</form>';
// }

?>

</body>
</html>