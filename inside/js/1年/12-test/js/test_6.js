const newElem = document.createElement('p');
newElem.textContent = '前に追加することができます';
const shoki = document.querySelector('.shoki');
shoki.prepend(newElem);