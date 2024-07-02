
function delayTask () {
    console.log('1秒後に実行する');
}
const timerID = setInterval(delayTask, 1000);
clearTimeout(timerID);