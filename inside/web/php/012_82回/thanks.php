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

$dsn = 'mysql:dbname=phpkiso;host=localhost';
$user = 'root';
$passwd = '';
$dbh = new PDO($dsn, $user, $passwd);
$dbh->query('SET NAMES utf8');

    print $name;
    print'様<br>';    
    print'ご予約ありがとうございました。<br>'; 
    print '頂いたご日時は「';
    print $datetime;
    print '」です<br>';


 
    $sql = 'insert into anketo(nickname, email, goiken) values("'.$name.'","'.$tel.'","'.$datetime.'")';
    $stmt = $dbh->prepare($sql);
    $stmt->execute();
    $dbh = null;
?>

</body>
</html>