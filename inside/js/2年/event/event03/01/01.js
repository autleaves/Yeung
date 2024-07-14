

const btn = document.querySelector('button');
const display = document.querySelector('.display');
const tips = document.querySelector('.tips');
btn.addEventListener('click', function(){
    tips.textContent = '答えは「富士山」です。';
    load_image();
});

function load_image() {
    let img = document.createElement('img');
    img.src = '富士山.jpg';
    display.appendChild(img);
}
