<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>体験レッス</title>
</head>
<body>
<?php
$memo=$_POST['memo'];
$le=$_POST['le'];
$memo=htmlspecialchars($memo);
$le=htmlspecialchars($le);

if($memo==''){
    print'ご記入ください。';
}else{
    print'お名前・電話番号・希望日時:';
    print $memo;
    print '<br>';
}
if($le==''){
    print'選択してください';
}else if($le=='v'){
    print'レッスン形式:来校';
}else{
    print'レッスン形式:オンライン';

}
?>  
</body>
</html>