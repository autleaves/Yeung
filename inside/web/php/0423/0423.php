<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php
$name = $_POST['name'];
$email = $_POST['email'];
$message = $_POST['message'];
$type_1 = '赤';
$type_2 = '青';
$type_3 = '黄';
$type_4 = '緑';

 print 'お名前：';
if($name == ''){
    print '入力してね';
}else {
 print $name.PHP_EOL;
}
 print '<br>';
 print 'メールアドレス：';
 if($email == ''){
    print '入力してね';
}else {
 print $email;
}
 print '<br>';
 print 'メッセージ：';
if($message == ''){
    print '入力してね';
}else {
 print $message;
}
 print '<br>';

 if(isset($_POST['color']) && is_array($_POST['color'])) {
    // Counting number of checked checkboxes.
    $checked_count = count($_POST['color']);
    print "旅行の種類：<br/>";
    // Loop to store and display values of individual checked checkbox.
    foreach($_POST['color'] as $selected) {
        // echo $selected;
        if($selected == 'red'){
            print $type_1;
            print '<br>';
        } else if ($selected == 'blue') {
            print $type_2;
            print '<br>';
        } else if ($selected == 'yellow') {
            print $type_3;
            print '<br>';
        } else if ($selected == 'green') {
            print $type_4;
            print '<br>';
        }
    }
}

?>
</body>
</html>