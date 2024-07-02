

const btn_minus = document.querySelector('.minus');
const btn_add = document.querySelector('.add');
btn_minus.addEventListener('click', function(event){
    const res = document.querySelector('.res');
    if(parseInt(res.textContent) > 0) {
        res.textContent = parseInt(res.textContent) - 1;
    } 
});
btn_add.addEventListener('click', function(event){
    const res = document.querySelector('.res');
    res.textContent = parseInt(res.textContent) + 1;
});