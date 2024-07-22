
const disp_0 = document.querySelector('.disp_0');
const disp_1 = document.querySelector('.disp_1');
const btn = document.querySelector('button');
btn.addEventListener('click', function(){
    btn.style.display = "none";
    for(let i = 0; i < 4; i++) {
            let img_0 = document.createElement('img');
            img_0.src = `flag_0_${i}.gif`;
            img_0.width = 200;
            img_0.height = 100;
            disp_0.appendChild(img_0);
            let img_1 = document.createElement('img');
            img_1.src = `flag_1_${i}.gif`;
            img_1.width = 200;
            img_1.height = 100;
            disp_1.appendChild(img_1);
    }
    
    
});
