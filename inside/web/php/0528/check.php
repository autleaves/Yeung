<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PHP基礎</title>
</head>
<body>

<?php
$nickname=$_POST['nickname'];
$email = $_POST['email'];
$goiken = $_POST['goiken'];

if($nickname==''){
    print'にゅうりょくしてね<br>';
}
else{
print'ようこそ';
print $nickname;
print'様';    
print'<br>'; 
}
if($email==''){
    print'メールアドレスが入力されていません。<br>';
}
else{
print'ようこそ';
print $email;
print'<br>';    
}
if($goiken==''){
    print'ご意見が入力されていません。<br>';
}
else{
print'ご意見「';
print $goiken;
print'」<br>'; 
}
?>

</body>
</html>