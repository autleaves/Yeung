
const result = confirm('本当に削除してよいですか？');
if (result) {
    alert("削除しました");
} else {
    alert("キャンセルしました");
}
alert("ユーザが回答するまで実行されない");