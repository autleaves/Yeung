const getScrollPercent = () => {
    const scrolled = window.scrollY;
    console.log(`${scrolled} スクロールされました`);
  
    const pageHeight = document.documentElement.scrollHeight;
    const viewHeight = document.documentElement.clientHeight;
    const percentage = scrolled / (pageHeight - viewHeight) * 100;
    document.querySelector('#bar').style.width = `${percentage}%`;

    console.log(`ページの高さ：${pageHeight}、表示領域の高さ：${viewHeight}`);
  }
  
  window.addEventListener('scroll', getScrollPercent);