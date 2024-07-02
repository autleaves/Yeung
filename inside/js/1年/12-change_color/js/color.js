


const container = document.querySelector('.container');
// container.addEventListener('click', ()=> {
//     container.style.backgroundColor = 'grey';
// })
// container.addEventListener('click', ()=> {
//     const colors = ['green', 'brown', 'blue', 'yellow'];
//     const n = Math.floor(Math.random()*colors.length);
//     const which_color = colors[n];
//     container.style.backgroundColor = which_color;
// })
container.addEventListener('click', ()=> {
    const r = Math.floor(Math.random()*256);
    const g = Math.floor(Math.random()*256);
    const b = Math.floor(Math.random()*256);
    const which_color = 'rgb(' + r + ',' + g + ',' + b + ')';
    container.style.backgroundColor = which_color;
})

function change_display () {
    const new value
    const display = document.querySelector('.display');

}

