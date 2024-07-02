


const btn = document.querySelector('button');
let span = document.querySelector('span');
btn.addEventListener('click', function(){
    btn.remove();
    span.textContent= '（予約済み）';
    create_elem();
});

function create_elem() {
    let p = document.createElement('p');
    p.textContent = 'ありがとうございました。';
    document.querySelector('body').appendChild(p);
}
