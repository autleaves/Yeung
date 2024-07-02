
const lis = document.querySelectorAll('li');
document.querySelector('button').addEventListener('click', function(){
    for(let i = 0; i < lis.length; i++) {
        lis[i].innerHTML = `<br><img src="flag_${i}.gif">`;
    }
});

