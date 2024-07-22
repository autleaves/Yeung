
const btn_s = document.querySelector('.small');
const btn_m = document.querySelector('.medium');
const btn_l = document.querySelector('.large');
const text = document.querySelector('p');
btn_s.addEventListener('click', function(){
    text.style.fontSize = "14px";
});
btn_m.addEventListener('click', function(){
    text.style.fontSize = "16px";
});
btn_l.addEventListener('click', function(){
    text.style.fontSize = "20px";
});

