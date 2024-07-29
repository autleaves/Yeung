

const btn_minus = document.querySelector('.minus');
const btn_add = document.querySelector('.add');
const btn_reset = document.querySelector('.reset');
const res = document.querySelector('.res');
btn_minus.addEventListener('click', function(){
    if((parseInt(res.textContent) - 10) > 0) {
        res.textContent = parseInt(res.textContent) - 10;
    } 
});
btn_add.addEventListener('click', function(){
    res.textContent = parseInt(res.textContent) + 2;
});
btn_reset.addEventListener('click', function(){
    res.textContent = 100;
});
