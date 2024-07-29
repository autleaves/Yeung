

const memo_input = document.querySelector('.new-memo');
const btn_add = document.querySelector('.add-memo');
const btn_clear = document.querySelector('.clear');
const btn_reset = document.querySelector('.reset');
const memo_list = document.querySelector('.memo-list');
btn_add.addEventListener('click', function(){
    const newMemo = document.createElement('li');
    newMemo.textContent = memo_input.value;
    memo_list.append(newMemo);
});
btn_clear.addEventListener('click', function(){
    memo_input.value = "";
});
btn_reset.addEventListener('click', function(){
    memo_list.innerHTML = "";
});