const echo  = (name, age) => {
    alert(`${name}さんの年齢は${age}歳ですね`);
}
const shimei = prompt('名前を入力してください');
const nenrei = prompt('年齢を入力してください');
echo(shimei, nenrei);