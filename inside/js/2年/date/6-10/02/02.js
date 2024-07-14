
let btns = document.querySelectorAll('button');
for(let i = 0; i < btns.length; i++){
    btn_addEventListener(btns[i], i);
    // console.log(`btns length= ${btns.length}`);
    const price = parseInt(document.querySelector(`.price_${i}`).textContent);
    // console.log(`price = ${price}`);
}
function btn_addEventListener(btn, i) {
    btn.addEventListener('click', function () {
        console.log('here 2...');
        const price = parseInt(document.querySelector(`.price_${i}`).textContent);
        const quantity = parseInt(document.querySelector(`.quantity_${i}`).textContent);
        alert(`料金は${price*quantity}円です`);
    });
}
