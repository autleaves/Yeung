
function delayTask () {
    console.log('1秒後に実行する');
}
const timerID = setTimeout(delayTask, 5000);
clearTimeout(timerID);