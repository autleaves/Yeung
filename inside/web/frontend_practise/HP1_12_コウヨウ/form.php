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
$email = $_POST['mail'];
$type_1 = '日帰りツアー';
$type_2 = '宿泊観光ツアー';
if(!empty($_POST['ryo'])) {
    // Counting number of checked checkboxes.
    $checked_count = count($_POST['ryo']);
    print "旅行の種類：<br/>";
    // Loop to store and display values of individual checked checkbox.
    foreach($_POST['ryo'] as $selected) {
        if($selected == 1){
            print $type_1;
            print '<br>';
        } else if ($selected == 2) {
            print $type_2;
            print '<br>';
        }
    }
}
else{
    print "チェックがされていません.";
    print '<br>';
}
if($email == '') {
    print 'メールアドレスが入力されていません。';
} else {
    print 'メールアドレス：';
    print $email;
}

print '<form>';
print '<INPUT type="button" value="戻る" onclick="history.back()">';
print '</form>';

?>
</body>
</html>