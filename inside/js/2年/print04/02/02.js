
const disp = document.querySelector('.display');
document.querySelector('button').addEventListener('click', function(){
    for(let i = 0; i < 8; i++) {
            let img = document.createElement('img');
            img.src = `flag_${i}.gif`;
            img.width = 200;
            img.height = 100;
            disp.appendChild(img);
    }
});

