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

$dsn = 'mysql:dbname=phpkiso;host=localhost';
$user = 'root';
$passwd = '';
$dbh = new PDO($dsn, $user, $passwd);
$dbh->query('SET NAMES utf8');

    print $name;
    print'様<br>';    
    print'ご予約ありがとうございました。<br>'; 
    print '頂いたご数量は「';
    print $quantity;
    print '」です<br>';


 
    $sql = 'insert into 84kai(name, tel, quantity,type) values("'.$name.'","'.$tel.'","'.$quantity.'","'.$shu.'")';
    $stmt = $dbh->prepare($sql);
    $stmt->execute();
    $dbh = null;
?>

</body>
</html>