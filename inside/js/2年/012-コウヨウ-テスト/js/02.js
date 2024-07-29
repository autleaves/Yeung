

const dummyContent = document.querySelector('.dummy');
for(let i=1; i<=1000; i++){
    dummyContent.textContent += `これはダミーテキストです${i}`;
}
window.addEventListener('scroll', function(){
    page_height = document.documentElement.scrollHeight;
    view_height = document.documentElement.clientHeight;
    console.log(`${window.scrollY}スクロールされました`);
    console.log(`ページの高さ：${page_height}、表示領域の高さ：${view_height}`);
});
