<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PHP基礎</title>
</head>
<body>

<?php
$name=$_POST['name'];
$tel = $_POST['tel'];
$datetime = $_POST['datetime'];
$lession = $_POST['le'];
$type_0 = '来校';
$type_1 = 'オンライン';

$name=htmlspecialchars($name);
$tel=htmlspecialchars($tel);

if($name=='' || $tel=='' || $datetime=='' || $lession==''){
    print '<form>';
    print '<input type="button" onclick="history.back()" value="戻る">';
    print '</form>';
} else {
    print '<form method="post" action="thanks.php">';
    print '<input name="name" type="text" value="'.$name.'"><br>';
    print '<input name="tel" type="text" value="'.$tel.'"><br>';
    print '<input name="datetime" type="text" value="'.$datetime.'"><br>';
    if($lession == 0){
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