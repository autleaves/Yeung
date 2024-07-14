<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PHP基礎</title>
</head>
<body>

<?php

$shu = $_POST['shu'];
$name=$_POST['name'];
$tel = $_POST['tel'];
$quantity = $_POST['quantity'];
$type_0 = '冊子';
$type_1 = 'チラシ';

// $name=htmlspecialchars($name);
// $tel=htmlspecialchars($tel);

if($name=='' || $tel=='' || $shu=='' || $quantity==''){
    print '<form>';
    print '<input type="button" onclick="history.back()" value="戻る">';
    print '</form>';
} else {
    print '<form method="post" action="thanks.php">';
    print '<input name="shu" type="text" value="'.$shu.'" hidden><br>';
    print '<input name="name" type="text" value="'.$name.'"><br>';
    print '<input name="tel" type="text" value="'.$tel.'"><br>';
    print '<input name="quantity" type="text" value="'.$quantity.'"><br>';
    if($shu == 0){
        print '<input name="le" type="text" value="'.$type_0.'"><br>';
    } else {
        print '<input name="le" type="text" value="'.$type_1.'"><br>';
    }
    print '<input type="button" onclick="history.back()" value="戻る">';
    print '<input type="submit" value="OK">';
    print '</form>';
}

?>

</body>
</html>